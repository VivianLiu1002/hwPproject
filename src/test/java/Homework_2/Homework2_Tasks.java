package Homework_2;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Homework2_Tasks {
    @Test
    public void testCase1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
        String actualMainTitle = BrowserUtils.getTitleWithJS(driver);
        String expectedMainTitle = "Web Orders Login";
        System.out.println(actualMainTitle.equals(expectedMainTitle) ? "mainTitle -->True" : "mainTitle-->False");

        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement login = driver.findElement(By.xpath("//input[@class='button']"));
        login.click();

        String actual2ndPageTitle = driver.getTitle();
        String expected2ndPageTitle = "Web Orders";
        System.out.println(actual2ndPageTitle.equals(expected2ndPageTitle) ? "2nd page title -->True" : "2nd page title--> false");

        WebElement header = driver.findElement(By.xpath("//h2[contains(text(),'All Orders')]"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "List of All Orders";
        System.out.println(actualHeader.equals(expectedHeader) ? "header-->True" : "header-->false");
    }

        @Test
                public void testCase2() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            ChromeDriver driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
            WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
            userName.sendKeys("Tester");
            WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
            password.sendKeys("test");
            WebElement login = driver.findElement(By.xpath("//input[@class='button']"));
            login.click();

            WebElement viewAllProducts=driver.findElement(By.linkText("View all products"));

            viewAllProducts.click();
            Thread.sleep(2000);
            viewAllProducts=driver.findElement(By.linkText("View all products"));
            System.out.println(viewAllProducts.isSelected() ? "viewAllProduct --> True" : "viewAllProduct-->False");

            WebElement header= driver.findElement(By.tagName("h2"));
            String actualHeader=BrowserUtils.getText(header);
            String expectedHeader="List of Products";
            System.out.println(actualHeader.equals(expectedHeader)? "header-->True": "header -->False");
            String actualUrl=driver.getCurrentUrl();
            System.out.println(actualUrl.contains("Products")? "Url --> True": "Url --> False");
        }
        @Test
    public void testCase3(){
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            ChromeDriver driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
            WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
            userName.sendKeys("Tester");
            WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
            password.sendKeys("test");
            WebElement login = driver.findElement(By.xpath("//input[@class='button']"));
            login.click();

            WebElement viewAllOrdersLink= driver.findElement(By.xpath("//a[.='View all orders']"));
            WebElement viewAllProductsLink= driver.findElement(By.xpath("//a[.='View all products']"));
            WebElement orderLink= driver.findElement(By.xpath("//a[.='Order']"));

            String viewAllOrdersHref=viewAllOrdersLink.getAttribute("href").trim();
            System.out.println(viewAllOrdersHref.contains("Default.aspx")? "viewAllOrdersHref -->True": "viewAllOrdersHref-->false");

            String viewAllProductsHref=viewAllProductsLink.getAttribute("href");
            System.out.println(viewAllProductsHref.contains("Products.aspx")? "viewAllProductsHref --> True": "viewAllProductsHref -->false");

            String orderHref=orderLink.getAttribute("href");
            System.out.println(orderHref.contains("Process.aspx")? "orderHref -->True" : "orderHref -->false");

        }

        @Test
    public void testCase4() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            ChromeDriver driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
            WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
            userName.sendKeys("Tester");
            WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
            password.sendKeys("test");
            WebElement login = driver.findElement(By.xpath("//input[@class='button']"));
            login.click();

            WebElement orderButton= driver.findElement(By.xpath("//a[.='Order']"));
            orderButton.click();
            WebElement productOptions=driver.findElement(By.tagName("select"));
            BrowserUtils.selectBy(productOptions,"ScreenSaver","text");
            WebElement quantity=driver.findElement(By.xpath("//input[@onchange='productsChanged()']"));
            quantity.sendKeys("5");

            WebElement name=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
            name.sendKeys("CodeFish IT School");
            WebElement street=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
            street.sendKeys("2200 E devon");
            WebElement city= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
            city.sendKeys("Des Plaines");
            WebElement state= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
            state.sendKeys("Illinois");
            WebElement zipcode=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
            zipcode.sendKeys("60018");

            WebElement masterCard= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_1"));
            masterCard.click();
            WebElement cardNumber=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
            cardNumber.sendKeys("444993876233");
            WebElement expirationDate=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
            expirationDate.sendKeys("03/24");
            WebElement processButton=driver.findElement(By.cssSelector(".btn_light"));
            processButton.click();
            Thread.sleep(2000);
            WebElement text=driver.findElement(By.xpath("//strong[contains(text(),' successfully added')]"));
            System.out.println(text.isDisplayed()? "text-->true":"text-->false");

            WebElement viewAllOrderButton=driver.findElement(By.linkText("View all orders"));
            viewAllOrderButton.click();

            List<WebElement> data=driver.findElements(By.xpath("//tr[2]//td"));

            List<String> expectedList= Arrays.asList("CodeFish IT School","ScreenSaver","5","06/02/2023","2200 E devon","Des Plaines","Illinois","60018",
            "MasterCard","444993876233","03/24");

            for (int i=1, k=0; i<data.size()-2; i++,k++) {
                if (data.get(i).getText().matches(expectedList.get(k))) {
                    Assert.assertTrue(BrowserUtils.getText(data.get(i)).equals(expectedList.get(k)));
                    break;
                }
            }

        }














}
