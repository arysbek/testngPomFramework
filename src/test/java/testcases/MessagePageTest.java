package test.java.testcases;

import com.facebook.Pages.*;
import com.facebook.base.TestBase;
import com.facebook.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MessagePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    MessengerPage messengerPage;

    public MessagePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPage = new LoginPage();
        messengerPage = new MessengerPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        homePage.clickOnMessengerLink();

    }

    @Test
    public void verifyMessageLabel() {
        Assert.assertTrue(messengerPage.verifyMessagesLabel(), "contact label is missing on the page");
    }

    @Test
    public void selectSingleContactTest() {
        messengerPage.selectUserByName("Nestan Rysbekova");
    }

    @Test
    public void selectMultipleContactTest() {
        messengerPage.selectUserByName("Nestan Rysbekova");
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        messengerPage.selectUserByName("Ulan Apsatar");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
