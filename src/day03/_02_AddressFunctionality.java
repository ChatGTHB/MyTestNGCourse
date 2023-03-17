package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utility.BaseDriver;
import utility.Tools;

import java.time.Duration;
import java.util.List;

public class _02_AddressFunctionality extends BaseDriver {
    /**
       Scenario;
       1- Open the site.
       2- Add Address.
       3- Edit the last address, change the name and surname and save it.
       4- Delete the last address.
    */
    @Test
    void addAddress() {

        Actions actions = new Actions(driver);

        WebElement addressBook = driver.findElement(By.xpath("(//a[text()='Address Book'])[1]"));
        addressBook.click();

        WebElement newAddressButton = driver.findElement(By.xpath("(//a[text()='New Address'])[1]"));
        newAddressButton.click();

        WebElement addressFirstName = driver.findElement(By.id("input-firstname"));

        Action action = actions.
                moveToElement(addressFirstName).
                click().
                sendKeys("FirstName").
                keyDown(Keys.TAB).
                keyUp(Keys.TAB).
                sendKeys("LastName").
                keyDown(Keys.TAB).
                keyUp(Keys.TAB).
                sendKeys("Company").
                keyDown(Keys.TAB).
                keyUp(Keys.TAB).
                sendKeys("Address1").
                keyDown(Keys.TAB).
                keyUp(Keys.TAB).
                sendKeys("Address2").
                keyDown(Keys.TAB).
                keyUp(Keys.TAB).
                sendKeys("City").
                keyDown(Keys.TAB).
                keyUp(Keys.TAB).
                sendKeys("PostCode").
                build();
        action.perform();

        WebElement countrySelect = driver.findElement(By.id("input-country"));
        Select country = new Select(countrySelect);
        country.selectByValue("160");

        // 1. Option
//        WebElement options = driver.findElement(By.cssSelector("select[id='input-zone']>option"));
//        wait.until(ExpectedConditions.stalenessOf(options));

        // 2. Option
        wait.until(ExpectedConditions.elementToBeClickable(countrySelect));

        WebElement stateSelect = driver.findElement(By.id("input-zone"));
        Select state = new Select(stateSelect);
        state.selectByIndex(7);

        // selectByVisibleText, selectByValue : It uses implicitly wait because it works like findElement.
        // selectByIndex : It does NOT work with implicitlyWait. but it works with ExplicitWait

        WebElement defaultAddress = driver.findElement(By.xpath("//input[@value='1']"));
        defaultAddress.click();

        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        Tools.successMessageValidation();
    }

    @Test(dependsOnMethods = {"addAddress"})
    void editAddress() {

        Actions actions = new Actions(driver);

        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List<WebElement> editAll = driver.findElements(By.linkText("Edit"));
        WebElement lastEdit = editAll.get(editAll.size() - 1);
        lastEdit.click();

        WebElement addressFirstName = driver.findElement(By.id("input-firstname"));

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.clear();
        firstName.sendKeys("FirstName2");

        WebElement lastname = driver.findElement(By.id("input-lastname"));
        lastname.clear();
        lastname.sendKeys("LastName2");

        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        Tools.successMessageValidation();
    }

    @Test(dependsOnMethods = {"editAddress"})
    void deleteAddress() {

        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List<WebElement> editAll = driver.findElements(By.linkText("Delete"));
        WebElement deletedAddress = editAll.get(editAll.size() - 2); // silinebilir 2. adres
        deletedAddress.click();

        Tools.successMessageValidation();
    }
}
