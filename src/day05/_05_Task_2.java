package day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utility.BaseDriverParameter;

import java.util.List;

public class _05_Task_2 extends BaseDriverParameter {
    /**
     * Bir önceki task(dataproviderlı) da yapılan testi PARAMETERDRIVER ile yapınız
     * sonrasında fakrlı tarayıcılar ile çalıştırınız. (crossbrowser)
     * sonrasında paralel çalıştırınız.(parallel)
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
