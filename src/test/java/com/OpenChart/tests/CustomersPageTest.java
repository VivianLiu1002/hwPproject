package com.OpenChart.tests;

import com.OpenChart.pages.CustomersPage;
import com.OpenChart.pages.OpenChartLoginPage;
import com.OpenChart.pages.OpenChartMainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomersPageTest extends OpenChartTestBase{
    @Test
    public void validateAddCustomerFunctionality() throws InterruptedException {
        OpenChartLoginPage openChartLoginPage=new OpenChartLoginPage(driver);
        openChartLoginPage.LoginFunctionality("demo","demo");
        OpenChartMainPage openChartMainPage=new OpenChartMainPage(driver);
        openChartMainPage.clickXButton();
        Thread.sleep(2000);
        openChartMainPage.clickCustomersButton();
        CustomersPage customersPage=new CustomersPage(driver);
        customersPage.addCustomerFunctionality(driver,"Vivian","Liu","vl123@gmail.com",
                "847123456","password","password");
        Assert.assertEquals(customersPage.warningMessage(),"Warning: You do not have permission to modify customers!");


    }
}
