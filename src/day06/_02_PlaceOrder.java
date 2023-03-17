package day06;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseDriver;


public class _02_PlaceOrder extends BaseDriver {
     /**
     Scenario :
     1- Open the site.
     2- Search the word "ipod" on the site
     3- Add the first one of the results to the basket.
     4- Click on Shopping Chart.
     5- Checkout.
     6- Click continue buttons and enter the information.
     7- Confirm that you have placed the order with en confirm.
     8- Verify with the text "Your order has been placed" on the page that appears.
     */

    @Test
    void proceedToCheckout() {

        Actions actions = new Actions(driver);

        WebElement searchBox = driver.findElement(By.cssSelector("[placeholder='Search']"));
        searchBox.sendKeys("ipod");

        WebElement searchButton = driver.findElement(By.cssSelector("[class='btn btn-default btn-lg']"));
        searchButton.click();

        WebElement addToCart = driver.findElement(By.xpath("//span[text()='Add to Cart']"));
        addToCart.click();

        WebElement shoppingCart = driver.findElement(By.xpath("(//span[text()='Shopping Cart'])[1]"));
        shoppingCart.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement bannerButton=driver.findElement(By.id("bitnami-close-banner-button"));

        js.executeScript("arguments[0].scrollIntoView(true);", bannerButton); //
        js.executeScript("arguments[0].click();", bannerButton);

        WebElement checkoutButton = driver.findElement(By.xpath("//a[text()='Checkout']"));
        checkoutButton.click();

        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-address")));
        continueButton.click();

        WebElement continueButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-address")));
        continueButton2.click();

        WebElement continueButton3 = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-method")));
        continueButton3.click();

        WebElement agree = driver.findElement(By.name("agree"));
        agree.click();

        WebElement continueButton4 = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-method")));
        continueButton4.click();

        WebElement confirm = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-confirm")));
        confirm.click();

        wait.until(ExpectedConditions.urlContains("success"));

        WebElement messageLabel = driver.findElement(By.xpath("//div[@id='content']/h1"));

        Assert.assertEquals("Your order has been placed!", messageLabel.getText());
    }
}
