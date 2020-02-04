package main.TestNGSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNGBasics {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rbooz\\Desktop\\Selenium jar\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://www.freecrm.com");
    }

    @AfterMethod
    public void  tearDown(){
        driver.quit();
    }

    @Test(priority = 3)
    public void verifyPageTitleTest(){
        String title = driver.getTitle();
        System.out.println("the page title is: " + title );

        Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small" );
    }

    @Test(priority = 2)
    public void verifyFreeCRMLogoTest() {
        boolean flag = driver.findElement(By.cssSelector("div.page:nth-child(1) header.page-head.header-corporate div.rd-navbar-wrap nav.rd-navbar.rd-navbar-original.rd-navbar-static div.rd-navbar-inner div.rd-navbar-wrap div.rd-navbar-panel div.rd-navbar-brand a.brand-name svg:nth-child(2) > image:nth-child(1)")).isDisplayed();
        Assert.assertTrue(flag);
    }

    @Test(priority = 1)
    public void verifyLogin() {
        WebElement login = driver.findElement(By.xpath("//span[contains(text(),'Log In')]"));
        login.click();

        driver.findElement(By.name("email")).sendKeys("rakyl.rys@gmail.com");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();

        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        Boolean invalid = driver.findElement(By.xpath("//p[contains(text(),'Invalid login')]")).isDisplayed();
        Assert.assertTrue(invalid);
    }


    public void login(String username, String password) {
        driver.findElement(By.name("email")).sendKeys("rakyl.rys@gmail.com");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();

    }

}
