package com.facebook.Pages;

import com.facebook.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessengerPage extends TestBase {

    public MessengerPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1[@class='_6-xo']")
    WebElement messagesLabel;

    public boolean verifyMessagesLabel() {
        return messagesLabel.isDisplayed();
    }

    public void selectUserByName(String name) {
        driver.findElement(By.xpath("//span[@class='_1ht6 _7st9'][contains(text(),'"+ name +"')]")).click();
    }
}
