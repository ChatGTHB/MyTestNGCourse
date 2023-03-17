package day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.BaseDriver;

import java.util.List;

public class _04_Task extends BaseDriver {
    /**
     * Daha önceki derslerde yaptğımız Search fonksiyonunu
     * mac,ipod ve samsung için DataProvider ile yapınız.
     */

    @Test(dataProvider = "getData")
    void searchFunction(String product) {

        WebElement searchInput = driver.findElement(By.cssSelector("[placeholder='Search']"));
        searchInput.clear();
        searchInput.sendKeys(product);

        WebElement searchButton = driver.findElement(By.cssSelector("[class='btn btn-default btn-lg']"));
        searchButton.click();

        List<WebElement> captions = driver.findElements(By.cssSelector("div[class='caption']>h4"));

        for (WebElement webElement : captions) {
            Assert.assertTrue(webElement.getText().toLowerCase().contains(product.toLowerCase()));
        }
    }

    @DataProvider
    public Object[] getData() {
        Object[] data = {"mac", "samsung", "ipod"};
        return data;
    }
}
