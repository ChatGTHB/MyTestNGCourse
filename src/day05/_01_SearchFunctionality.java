package day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utility.BaseDriver;
import utility.BaseDriverParameter;

import java.util.List;

public class _01_SearchFunctionality extends BaseDriverParameter {
    /**
     Scenario ;
     1- Open the site.
     2- Search by sending the word "mac".
     3- Verify that the word mac is included in the results.
     4- Do the same for "samsung".
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
