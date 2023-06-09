package com.OpenChart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenChartMainPage {
    public OpenChartMainPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".btn-close")
    WebElement xButton;
    @FindBy(xpath = "//a[contains(text(),' Customers')]")
    WebElement customerCollapseButton;
    @FindBy(xpath = "//ul[@class='collapse show']//a[contains(text(),'Customers')]")
    WebElement subCustomersButton;

    public void clickXButton(){
        xButton.click();
    }
    public void clickCustomersButton() throws InterruptedException {
        Thread.sleep(2000);
        customerCollapseButton.click();
        Thread.sleep(2000);
        subCustomersButton.click();
    }
}
