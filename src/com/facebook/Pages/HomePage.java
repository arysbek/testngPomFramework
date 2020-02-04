package com.facebook.Pages;

import com.facebook.base.TestBase;
import com.gargoylesoftware.htmlunit.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HomePage extends TestBase {

//    Elements or Variables

    @FindBy(xpath = "//div[contains(text(),'Rbooz Pro')]")
    WebElement userNameLabel;

    @FindBy(xpath = "//li[@id='navItem_217974574879787']//div[@class='linkWrap noCount'][contains(text(),'Messenger')]")
    WebElement messenger;

    @FindBy(xpath = "//div[contains(text(),'News Feed')]")
    WebElement newsFeed;

    @FindBy(xpath = "//li[@id='navItem_1434659290104689']//div[@class='linkWrap noCount'][contains(text(),'Groups')]")
    WebElement groups;


//    * Actions or Methods

    public HomePage() {
        PageFactory.initElements(driver,this);
    }

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    public boolean verifyCorrectUserName() {
        return userNameLabel.isDisplayed();
    }

    public MessengerPage clickOnMessengerLink() {
        messenger.click();
        return new MessengerPage();
    }

    public NewsFeedPage clickOnNewsFeedLink() {
        newsFeed.click();
        return new NewsFeedPage();
    }

    public GroupsPage clickOnGroupsLink() {
        groups.click();
        return new GroupsPage();
    }

}
