package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utility.BaseDriver;

import java.util.List;

public class _05_SearchFunctionality extends BaseDriver {
    /*
      Senaryo ;
      1- Siteyi açınız.
      2- mac kelimesini göndererek aratınız.
      3- Çıkan sonuçlarda mac kelimesinin geçtiğini doğrulayınız.
      4- aynı işlemi samsung için de yapınız
    */

    @Test
    @Parameters("searchedWord")
    void searchFunction(String product) {
        WebElement searchBox= driver.findElement(By.cssSelector("[placeholder='Search']"));
        searchBox.sendKeys(product);

        WebElement searchButton= driver.findElement(By.cssSelector("[class='btn btn-default btn-lg']"));
        searchButton.click();

       List<WebElement> captions= driver.findElements(By.cssSelector("div[class='caption']>h4"));

       for(WebElement webElement:captions){
           Assert.assertTrue(webElement.getText().toLowerCase().contains(product.toLowerCase()));
       }
    }
}
