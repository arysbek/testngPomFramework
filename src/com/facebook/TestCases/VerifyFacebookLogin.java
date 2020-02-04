//package com.facebook.TestCases;
//
//import com.facebook.Pages.LoginPage;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.Test;
//
//import java.util.concurrent.TimeUnit;
//
//public class VerifyFacebookLogin {
//
//    @Test
//    public void verifyValidLogin() {
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Rbooz\\Desktop\\Selenium jar\\geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//        driver.get("https://facebook.com/login");
//
//        LoginPage login = new LoginPage(er);
//        try {
//            Thread.sleep(5*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
//        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.quit();
//    }
//
//}
