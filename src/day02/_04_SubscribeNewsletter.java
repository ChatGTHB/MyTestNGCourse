package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utility.BaseDriver;
import utility.Tools;

public class _04_SubscribeNewsletter extends BaseDriver {
    /*
       Scenario
       1- Open the site.
       2- Subscribe to Newsletter Subscribe transaction. (Yes)
    */
    @Test(priority = 1)
    void subscribeFunctionYes() {

        WebElement newsletter = driver.findElement(By.xpath("//a[text()='Newsletter']"));
        newsletter.click();

        WebElement subscribeYes = driver.findElement(By.xpath("//input[@value='1']"));
        subscribeYes.click();

        WebElement subscribeContinue = driver.findElement(By.xpath("//input[@value='Continue']"));
        subscribeContinue.click();

        Tools.successMessageValidation();

    }

    /*
    3- Leave the Newsletter Subscribe transaction with a separate test from subscription (No).
    */
    @Test(priority = 2)
    void subscribeFunctionNo() {

        WebElement newsletter = driver.findElement(By.xpath("//a[text()='Newsletter']"));
        newsletter.click();

        WebElement subscribeNo = driver.findElement(By.xpath("//input[@value='0']"));
        subscribeNo.click();

        WebElement subscribeContinue = driver.findElement(By.xpath("//input[@value='Continue']"));
        subscribeContinue.click();

        Tools.successMessageValidation();

    }

    /*
    4- Check the Newsletter Subscribe status with a separate test, if it is yes, do no, and if no, be yes.
    */
    @Test(priority = 3)
    void subscribeFunctionForBoth() {

        WebElement newsletter = driver.findElement(By.xpath("//a[text()='Newsletter']"));
        newsletter.click();

        WebElement subscribeYes = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement subscribeNo = driver.findElement(By.xpath("//input[@value='0']"));

        if (subscribeYes.isSelected()) {
            subscribeNo.click();
        } else {
            subscribeYes.click();
        }

        WebElement subscribeContinue = driver.findElement(By.xpath("//input[@value='Continue']"));
        subscribeContinue.click();

        Tools.successMessageValidation();
    }

}



