package day06;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseDriver;

public class _03_PlaceOrder extends BaseDriver {
    /**
     * Scenario :
     * 1- Open the site.
     * 2- Search the word "ipod" on the site
     * 3- Add the first one of the results to the basket.
     * 4- Click on Shopping Chart.
     * 5- Checkout.
     * 6- Click continue buttons and enter the information.
     * 7- Confirm that you have placed the order with en confirm.
     * 8- Verify with the text "Your order has been placed" on the page that appears.
     */

    @Test
    void proceedToCheckout() {

        _03_PlaceOrderElements elements = new _03_PlaceOrderElements();

        elements.searchBox.sendKeys("ipod");

        elements.searchButton.click();

        elements.addToCart.click();

        elements.shoppingCart.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elements.bannerButton); //
        js.executeScript("arguments[0].click();", elements.bannerButton);

        elements.checkoutButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.continueButton)).click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.continueButton2)).click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.continueButton3)).click();

        elements.agree.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.continueButton4)).click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.confirm)).click();

        wait.until(ExpectedConditions.urlContains("success"));

        Assert.assertEquals("Your order has been placed!", elements.messageLabel.getText());
    }
}
