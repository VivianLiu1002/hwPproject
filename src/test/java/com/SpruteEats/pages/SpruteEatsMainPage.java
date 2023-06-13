package com.SpruteEats.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpruteEatsMainPage {
    public SpruteEatsMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='global-nav__list-item-link']//span[.='Ingredients']")
    WebElement ingredients;
    @FindBy(xpath = "//ul[@class='global-nav__sub-list']//a[contains(text(),'Fish & Seafood')]")
    WebElement fishAndSeafood;


    public void chooseIngredients(WebDriver driver) throws InterruptedException {
        Actions actions=new Actions(driver);
        actions.moveToElement(ingredients).perform();
        Thread.sleep(2000);
        //actions.moveToElement(fishAndSeafood).perform();

        actions.click(fishAndSeafood).perform();
    }

}
