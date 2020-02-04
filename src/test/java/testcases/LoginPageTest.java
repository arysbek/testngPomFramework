package test.java.testcases;

import com.facebook.Pages.HomePage;
import com.facebook.Pages.LoginPage;
import com.facebook.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        System.out.println("The title is equal to :" + title);
        Assert.assertEquals(title, "Facebook - Log In or Sign Up" );
        driver.quit();
    }

    @Test(priority = 2)
    public void loginTest() {
       homePage =  loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterMethod
    public void end() {
        driver.quit();
    }

}
