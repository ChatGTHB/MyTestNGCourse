package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utility.BaseDriver;

public class _04_ContactUs extends BaseDriver {
    /**
    1- Click ContactUs
    2- Type a message of at least 10 characters in the message box.
    3- After submitting, verify the Contact US text.
    */

    @Test
    @Parameters("message")
    void contactUs(String incomingMessage) {

        WebElement contactUsLink = driver.findElement(By.linkText("Contact Us"));
        contactUsLink.click();

        WebElement textArea = driver.findElement(By.cssSelector("textarea[name='enquiry']"));
        textArea.sendKeys(incomingMessage);

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        // submitButton.click();
        submitButton.submit();

        WebElement verificiationMessage = driver.findElement(By.xpath("//h1[text()='Contact Us']"));

        Assert.assertTrue(driver.getCurrentUrl().contains("success"));
    }
}
