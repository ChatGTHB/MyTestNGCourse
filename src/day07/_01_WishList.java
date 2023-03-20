package day07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utility.BaseDriver;
import utility.Tools;

import java.util.List;

public class _01_WishList extends BaseDriver {
    /*
    Senaryo ;
    1- Siteye gidiniz..
    2- "ipod" ürününü aratınız."ipod" u xml den gönderiniz
    3- çıkan elemanlardan random bir elemanı Add Wish butonuna tıklayınız.
    4- Daha sonra WishList e tıklatınız
    5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.
    */

    @Test
    @Parameters("searchedText")
    void addToWishList(String text) {

        WebElement searchBox= driver.findElement(By.cssSelector("[placeholder='Search']"));
        searchBox.sendKeys(text);

        WebElement searchButton= driver.findElement(By.cssSelector("[class='btn btn-default btn-lg']"));
        searchButton.click();

        List<WebElement> searchResults=driver.findElements(By.cssSelector("div[class='caption']>h4>a"));
        int randomSelection= Tools.RandomGenerator(searchResults.size());
        String wishItemText=searchResults.get(randomSelection).getText();


        List<WebElement> wishLists=driver.findElements(By.xpath("//button[@data-original-title='Add to Wish List']"));
        wishLists.get(randomSelection).click();

        WebElement wishProductsButton=driver.findElement(By.id("wishlist-total"));
        wishProductsButton.click();

        List<WebElement> wishTableNames=driver.findElements(By.cssSelector("[class='text-left']>a"));

        Tools.listContainsString(wishTableNames,wishItemText);

    }
}
