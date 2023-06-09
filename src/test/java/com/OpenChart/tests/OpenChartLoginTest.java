package com.OpenChart.tests;

import com.OpenChart.pages.OpenChartLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenChartLoginTest extends OpenChartTestBase{
    @Test
    public void HappyPathLoginTest() throws InterruptedException {
        OpenChartLoginPage openChartLoginPage = new OpenChartLoginPage(driver);
        openChartLoginPage.LoginFunctionality("demo","demo");
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle().trim(), "Dashboard");
    }
    @Test
    public void validateNegativeLogin() throws InterruptedException {
        OpenChartLoginPage openChartLoginPage = new OpenChartLoginPage(driver);
        openChartLoginPage.LoginFunctionality("wrongUserName","WrongPassword");
        Assert.assertEquals(openChartLoginPage.errorMessage(),"No match for Username and/or Password.");
    }
}
