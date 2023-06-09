package com.OpenChart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage {
    public CustomersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[@class='fas fa-plus']")
    WebElement plusButton;
    @FindBy(css = "#input-firstname")
    WebElement firstName;
    @FindBy(css = "#input-lastname")
    WebElement lastName;
    @FindBy(css = "#input-email")
    WebElement email;
    @FindBy(css = "#input-telephone")
    WebElement telephone;
    @FindBy(css = "#input-password")
    WebElement password;
    @FindBy(css = "#input-confirm")
    WebElement confirmPassword;
    @FindBy(css = "#input-newsletter")
    WebElement newsLetter;
    @FindBy(css = "#input-safe")
    WebElement safe;
    @FindBy(xpath = "//button[@aria-label='Save']")
    WebElement saveButton;
    @FindBy(xpath = "//div[@id='alert']")
    WebElement warningMessage;


    public void addCustomerFunctionality(WebDriver driver, String firstName, String lastName, String email,
                                         String telephone, String password, String confirmPassword) throws InterruptedException {
        plusButton.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.telephone.sendKeys(telephone);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(confirmPassword);
        BrowserUtils.scrollWithJS(driver, safe);
        if (!newsLetter.isSelected() && newsLetter.isEnabled()) {
            Thread.sleep(2000);
            newsLetter.click();
        }
        if (!safe.isSelected() && safe.isEnabled()) {
            safe.click();
        }
        BrowserUtils.scrollWithJS(driver, saveButton);
        Thread.sleep(2000);
        saveButton.click();
    }

    public String warningMessage() throws InterruptedException {
        Thread.sleep(2000);
        return BrowserUtils.getText(warningMessage);
    }
}


