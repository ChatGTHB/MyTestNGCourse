package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utility.BaseDriver;
import utility.Tools;

public class _04_SubscribeNewsletter extends BaseDriver {
    /*
      Senaryo
      1- Siteyi açınız.
      2- Newsletter  Subscribe işlemini abone olunuz.(YES)
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
    3- Ayrı bir test ile Newsletter  Subscribe işlemini abonelikten çıkınız(NO)
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
    4- Ayrı bir test ile Newsletter  Subscribe durumunu kontrol ediniz YES ise NO, NO ise YES yapınız.
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



