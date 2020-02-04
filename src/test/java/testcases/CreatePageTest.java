package test.java.testcases;

import com.facebook.Pages.*;
import com.facebook.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreatePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    CreatePage createPage;


    public CreatePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        createPage = new CreatePage();
    }

    @Test
    public void createNewPage() {
        createPage.clickOnCreateNewPage("lalafo","Cars");
    }

    @Test
    public void verifyTitleOfCreatePage() {
        String title = createPage.verifyCreatePageTitle();
        Assert.assertEquals(title,"Facebook");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
