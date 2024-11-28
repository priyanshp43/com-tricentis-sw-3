package computers;


import browserfactory.BaseTest;
import homepage.TopMenuTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.time.Duration;

import static browserfactory.BaseTest.driver;
import static org.junit.Assert.assertEquals;

/**
 * Write the following Test:
 * 1. Test name verifyProductArrangeInAlphaBaticalOrder()
 * 1.1 Click on the COMPUTERS Menu.
 * 1.2 Click on the Desktop
 * 1.3 Select Sort By option "Name: Z to A"
 * 1.4 Verify the Product will be arranged in Descending order.
 * 2. Test name verifyProductAddedToShoppingCartSuccessFully()
 * 2.1 Click on the COMPUTERS Menu.
 * 2.2 Click on the Desktop
 * 2.3 Select Sort By option "Name: A to Z"
 * 2.4 Click on the "Add To Cart" button of the product name ‘Build your own computer’
 * 2.5 Verify the Text "Build your own computer"
 * 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using the Select class
 * 2.7.Select "8GB [+$60.00]" using the Select class.
 * 2.8 Select HDD radio button "400 GB [+$100.00]"
 * 2.9 Select the OS radio button "Windows 10 [+$60.00]"
 * <p>
 * 2.10 Check Two Checkboxes "Microsoft Office [+$50.00]" and "Total Commander
 * [+$5.00]"
 * 2.11 Verify the price "1200.00"
 * 2.12 Click on the "Add to card" Button.
 * 2.13 Verify the Message "The product has been added to your shopping cart" on the
 * Top green Bar
 * 2.14 After that close the bar by clicking on the cross button.
 * 2.15 Then MouseHover on "Shopping cart" and click on the "Go to cart" button.
 * 2.16 Verify the message "Shopping cart"
 * 2.17 Change the Qty to "2" and Click on "Update shopping cart"
 * 2.18 Verify the Total "2,950.00"
 * 2.19 click on the checkbox “I agree with the terms of service”
 * 2.20 Click on “Checkout”
 * 2.21 Verify the Text “Welcome, Please Sign In!”
 * 2.22 Click on the “Checkout as Guest” Tab
 * 2.23 Enter the First name
 * 2.24 Enter the Last name
 * 2.25 Enter the email
 * 2.26 Select the Country “United Kingdom” using the select class
 * 2.27 Enter the city
 * 2.28 Enter the Address1
 * 2.29 Enter the Zip/Postal code
 * 2.30 Enter the Phone number
 * 2.31 Click on the “Continue” button
 * 2.32 Click on the “Continue” button
 * 2.33 Click on the Radio Button “Next Day Air($0.00)”
 * 2.34 Click on the “Continue” button
 * 2.35 Select the Radio Button “Credit Card”
 * 2.36 Click on the “Continue” button
 * 2.37 Select “Master card” From the Select credit card dropdown using the Select class
 * 2.38 Enter the Cardholder's name
 * 2.39 Enter the Card number
 * 2.40 Select the Expiration date using the select class
 * 2.41 Enter the Card code
 * 2.42 Click on the “Continue” button
 * 2.43 Verify “Payment Method” is “Credit Card”
 * 2.44 Verify “Shipping Method” is “Next Day Air”
 * 2.45 Verify Total is “2,950.00”
 * 2.46 Click on the “Confirm” button
 * 2.47 Verify the Text “Thank You”
 * 2.48 Verify the message “Your order has been successfully processed!”
 * 2.49 Click on the “Continue” button
 * 2.50 Verify the text “Welcome to our store”
 */
public class TestSuite extends Utility {

    String baseUrl = "https://demowebshop.tricentis.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {


        // Navigate to Computers > Desktop
        new TopMenuTest().selectMenu("Computers");
        driver.findElement(By.linkText("Desktops")).click();

        // Sort products by Name: Z to A
        Select sortBy = new Select(driver.findElement(By.id("products-orderby")));
        sortBy.selectByVisibleText("Name: Z to A");

        // Verify product order is descending
        String actualText = driver.findElement(By.id("products-orderby")).getText();
        assertEquals(actualText, "Name: Z to A");

    }


    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        // 2.1 Click on the COMPUTERS Menu.
        clickOnElement(By.xpath("(//a[normalize-space()='Computers'])[1]"));

        // Click on the Desktop
        // 2.2 Click on the Desktop
        clickOnElement(By.linkText("Desktops"));

        //  Select Sort By option "Name: Z to A"
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='products-orderby']"));
        Select select = new Select(dropdown);
        //  Select Sort By option "Name: Z to A"
        select.selectByVisibleText("Name: Z to A");
        // 2.3 Select Sort By option "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");

        //  Click on the "Add To Cart" button of the product name ‘Build your own computer’
        // 2.4 Click on the "Add To Cart" button of the product name ‘Build your own computer’
        clickOnElement(By.partialLinkText("Build your own computer"));

        String expectedText = "Build your own computer";
        String actualText = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedText, actualText);
        // 2.5 Verify the Text "Build your own computer"
        assertMethod("Build your own computer", By.tagName("h1"));

        // Select "2.2 GHz Intel Pentium Dual-Core E2200" using the Select class
        // 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using the Select class
        WebElement dropdownForProcessor = driver.findElement(By.xpath("(//select[@id='product_attribute_16_6_5'])[1]"));
        Select select1 = new Select(dropdownForProcessor);
        select1.selectByIndex(2);

        // 2.8 Select HDD radio button "400 GB [+$100.00]"
        clickOnElement(By.xpath("(//input[@id='product_attribute_16_3_6_19'])[1]"));
        // 2.9 Select the OS radio button "Windows 10 [+$60.00]"
        clickOnElement(By.xpath("(//input[@id='product_attribute_16_4_7_21'])[1]"));

        //  selectFromDropDown(By.xpath("(//select[@id='product_attribute_16_6_5'])[1]"),"8GB[+60.00]");
        // 2.10 Check Two Checkboxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.xpath("(//input[@id='product_attribute_16_8_8_24'])[1]"));

        //   clickOnElement(By.xpath("(//select[@id='product_attribute_16_6_5'])[1]"));
        // 2.11 Verify the price "1200.00"
        assertMethod("1200.00", By.xpath("(//span[@class='price-value-16'])[1]"));

        //   selectFromDropDown(By.xpath("(//select[@id='product_attribute_16_6_5'])[1]"), "8GB[+60.00]");
        // 2.12 Click on the "Add to card" Button
        clickOnElement(By.id("add-to-cart-button-16"));

        // 2.13 Verify the Message "The product has been added to your shopping cart" on the Top green Bar
        assertMethod1("The product has been added to your shopping cart", By.xpath("//p[@class='content']"));

        // Select "8GB [+$60.00]" using the Select class
        // selectFromDropDown(By.xpath("(//select[@id='product_attribute_16_6_5'])[1]"),"8GB[+60.00]");
        // 2.14 After that close the bar by clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));

        // 2.15 Then MouseHover on "Shopping cart" and click on the "Go to cart" button.
        mouseHoverAndClick(By.xpath("//span[normalize-space()='Shopping cart']"));
        clickOnElement(By.xpath("//input[@value='Go to cart']"));

        //  WebElement dropdownForRam = driver.findElement(By.xpath("(//select[@id='product_attribute_16_6_5'])[1]"));
        //  Select select2 = new Select(dropdownForRam);
        //  select1.selectByVisibleText("8GB[+60.00]");
        // 2.16 Verify the message "Shopping cart"
        assertMethod("Shopping cart", By.xpath("(//h1[normalize-space()='Shopping cart'])[1]"));

        //   selectFromDropDown(By.id("product_attribute_2"), "8GB [+$60.00]");
        Thread.sleep(2000);
        // 2.17 Change the Qty to "2" and Click on "Update shopping cart"

        WebElement qty = driver.findElement(By.cssSelector(".qty-input"));
        qty.clear();
        qty.sendKeys("2");
        driver.findElement(By.name("updatecart")).click();

        // Select HDD radio button "400 GB [+$100.00]"
        clickOnElement(By.xpath("(//input[@id='product_attribute_16_3_6_19'])[1]"));
        // 2.18 Verify the Total "2,950.00"
        Thread.sleep(2000);
        assertMethod("2980.00", By.xpath("//span[@class='product-subtotal']"));

        // Select the OS radio button "Windows 10 [+$60.00]"
        clickOnElement(By.xpath("(//input[@id='product_attribute_16_4_7_21'])[1]"));
        //  2.19 click on the checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //  2.20 Click on “Checkout”
        clickOnElement(By.id("checkout"));

        // Check Two Checkboxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.id("product_attribute_16_8_8_22"));
        clickOnElement(By.xpath("(//input[@id='product_attribute_16_8_8_24'])[1]"));
        // 2.21 Verify the Text “Welcome, Please Sign In!”
        assertMethod("Welcome, Please Sign In!", By.tagName("h1"));

        // 2.22 Click on the “Checkout as Guest” Tab
        clickOnElement(By.xpath("//input[@value='Checkout as Guest']"));

        // Verify the price "1200.00"
        String expectedPriceText = "1200.00";
        String actualPriceText = driver.findElement(By.xpath("(//span[@class='price-value-16'])[1]")).getText();
        Assert.assertEquals(expectedPriceText, actualPriceText);
        // 2.23 Enter the First name
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Prashant");

        // Click on the "Add to card" Button
        clickOnElement(By.id("add-to-cart-button-16"));
        //  2.24 Enter the Last name
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_LastName']")).sendKeys("Patel");

        // Verify the Message "The product has been added to your shopping cart" on the Top green Bar
        String expectedCartText = "The product has been added to your shopping cart";
        String actualCartText = driver.findElement(By.xpath("//p[@class='content']")).getText();
        Assert.assertEquals(expectedCartText, actualCartText);
        // 2.25 Enter the email
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_Email']")).sendKeys("patel123@gmail.com");

        // After that close the bar by clicking on the cross button.
        // 2.26 Select the Country “United Kingdom” using the select class
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");

        // 2.27 Enter the city
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("London");

        //  2.28 Enter the Address1
        driver.findElement(By.xpath("(//input[@id='BillingNewAddress_Address1'])[1]")).sendKeys("Oxford Street");

        // 2.29 Enter the Zip/Postal code
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("NA1 2AB");

        //  2.30 Enter the Phone number
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("079876543");
        // 2.31 Click on the “Continue” button
        clickOnElement(By.xpath("//input[@onclick='Billing.save()']"));
        // 2.32 Click on the “Continue” button
        clickOnElement(By.xpath("//input[@onclick='Shipping.save()']"));

        // 2.33 Click on the Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        //  2.34 Click on the “Continue” button
        clickOnElement(By.xpath("(//input[@class='button-1 shipping-method-next-step-button'])[1]"));
        // 2.35 Select the Radio Button “Credit Card”
        clickOnElement(By.xpath("(//input[@id='paymentmethod_2'])[1]"));
        // 2.36 Click on the “Continue” button
        clickOnElement(By.xpath("(//input[@class='button-1 payment-method-next-step-button'])[1]"));
        // 2.37 Select “Master card” From the Select credit card dropdown using the Select class
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");
        // 2.38 Enter the Cardholder's name
        driver.findElement(By.xpath("//input[@id='CardholderName']")).sendKeys("Prashant P");
        // 2.39 Enter the Card number
        driver.findElement(By.xpath("//input[@id='CardNumber']")).sendKeys("567583940349293");
        // 2.40 Select the Expiration date using the select class
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "08");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2029");
        // 2.41 Enter the Card code
        driver.findElement(By.xpath("//input[@id='CardCode']")).sendKeys("325");
        // 2.42 Click on the “Continue” button
        clickOnElement(By.xpath("(//input[@class='button-1 payment-info-next-step-button'])[1]"));
        // 2.43 Verify “Payment Method” is “Credit Card
        assertMethod("Credit Card", By.xpath("//li[@class='payment-method']"));
        // 2.44 Verify “Shipping Method” is “Next Day Air”
        assertMethod("Next Day Air", By.xpath("//li[@class='shipping-method']"));
        // 2.45 Verify Total is “2,950.0
        assertMethod("2980.00", By.xpath("//span[@class='product-price order-total']//strong[contains(text(),'2980.00')]"));
        // 2.46 Click on the “Confirm” button
        clickOnElement(By.xpath("//input[@value='Confirm']"));
        // 2.47 Verify the Text “Thank You”
        assertMethod1("Thank you", By.xpath("//h1[normalize-space()='Thank you']"));
        //  2.48 Verify the message “Your order has been successfully processed!”
        assertMethod1("Your order has been successfully processed!", By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
        // 2.49 Click on the “Continue” button
        clickOnElement(By.xpath("//input[@value='Continue']"));
        // 2.50 Verify the text &ldquo;Welcome to our store"
        assertMethod1("Welcome to our store", By.xpath("//h2[normalize-space()='Welcome to our store']"));
    }

    @After
    public void tearDown() {
   closeBrowser();
    }
}


