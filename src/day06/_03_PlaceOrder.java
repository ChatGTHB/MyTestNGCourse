package day06;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseDriver;

public class _03_PlaceOrder extends BaseDriver {
    /*
   Senaryo :
   1- Siteyi açınız.
   2- Sitede "ipod" kelimesini aratınız
   3- Çıkan sonuçlardan ilkini sepete atınız.
   4- Shopping Chart a tıklatınız.
   5- Checkout yapınız.
   6- Continue butonalarına tıklatıp bilgileri giriniz.
   7- En confirm ile siparişi verdiğinizi doğrulayınız.
      doğrulamayı çıkan sayfadaki "Your order has been placed" yazısı ile yapınız.
*/

    @Test
    void proceedToCheckout() {

        _03_PlaceOrderElements elements=new _03_PlaceOrderElements();

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
