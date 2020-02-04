package test.java.testcases;

import com.facebook.Pages.*;
import com.facebook.base.TestBase;
import com.facebook.util.TestUtil;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    MessengerPage messengerPage;
    GroupsPage groupsPage;
    NewsFeedPage newsFeedPage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test
    public void verifyHomePageTitle() {
        String title = homePage.verifyHomePageTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Facebook", "HomePage Did not matched" );
    }

    @Test
    public void verifyUserName() {
        Assert.assertTrue(homePage.verifyCorrectUserName());
    }

    @Test
    public void clickOnMessenger() {
        messengerPage = homePage.clickOnMessengerLink();
    }

    @Test
    public void clickOnGroups() {
        groupsPage = homePage.clickOnGroupsLink();
    }

    @Test
    public void clickOnNewsFeed() {
        newsFeedPage = homePage.clickOnNewsFeedLink();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
