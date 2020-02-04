package com.facebook.Pages;

import com.facebook.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class will store all the locators of login page**/

public class LoginPage extends TestBase {

    @FindBy(id="email")
    WebElement username;

    @FindBy(id = "pass")
    WebElement password;

    @FindBy(xpath = "//input[@id='u_0_2']")
    WebElement loginButton;

    @FindBy(xpath= "//div[@class='_4rbf _53ij']//a[contains(text(),'Forgot Password?')]")
    WebElement popMessageFailedLogin;

    @FindBy(xpath = "//a[contains(text(),'Forgot account?')]")
    WebElement forgotPassword;

    @FindBy(xpath = "//button[@id='u_0_17']")
    WebElement singUp;

    @FindBy(xpath = "//a[@class='_8esh']")
    WebElement createPage;

    public LoginPage() {
        PageFactory.initElements(driver,this);
    }

    // Actions:
    public HomePage login(String un, String pwd)  {
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginButton.click();
        return new HomePage();
    }

    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

}
