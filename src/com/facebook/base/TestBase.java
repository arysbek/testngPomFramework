package com.facebook.base;

import com.facebook.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\Rbooz\\Desktop\\Test\\testng1\\src\\com\\facebook\\config\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization(){
        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome")) {

            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rbooz\\Desktop\\Selenium jar\\chromedriver.exe");
            driver = new ChromeDriver(options);

        }else if(browserName.equals("FF")) {
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("permissions.default.desktop-notification", 1);
            DesiredCapabilities capabilities=DesiredCapabilities.firefox();
            capabilities.setCapability(FirefoxDriver.PROFILE, profile);

            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Rbooz\\Desktop\\Selenium jar\\geckodriver.exe");
            driver = new FirefoxDriver(capabilities);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }
}






