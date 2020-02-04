package com.facebook.Pages;

import com.facebook.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePage extends TestBase {

    @FindBy(xpath = "//div[@class='_273_ _2iev'][contains(text(),'Page')]")
    WebElement createPageLink;

    @FindBy(xpath = "//a[@id='creation_hub_entrypoint']")
    WebElement createLink;

    @FindBy(xpath = "//td[@class='prl _51mw _51m-']//div[@class='_43rm'][contains(text(),'Get Started')]")
    WebElement comunityPagelink;

    @FindBy(xpath = "//input[@id='NON_BUSINESS_SUPERCATEGORYPageNameInput']")
    WebElement pageName;

    @FindBy(xpath = "//label[@id='js_28l']//input[@placeholder='Add a category to describe your Page']")
    WebElement pageCategory;

    @FindBy(xpath = "//div[@class='_3a5o _38h3 _21--']//div[@class='_43rm'][contains(text(),'Continue')]")
    WebElement continueButton;


    public CreatePage() {
        PageFactory.initElements(driver,this);
    }

    public String verifyCreatePageTitle() {
        return driver.getTitle();
    }

    public void clickOnCreateNewPage(String name, String category) {
        createLink.click();
        createPageLink.click();
        comunityPagelink.click();
        pageName.sendKeys(name);
        pageCategory.sendKeys(category);
        continueButton.click();

    }

}
