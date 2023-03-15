package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseDriver;

public class _02_Example extends BaseDriver {
    @Test
    void loginTest(){

        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement loginMail= driver.findElement(By.id("input-email"));
        loginMail.sendKeys("test123@testing.com");

        WebElement loginPassword= driver.findElement(By.id("input-password"));
        loginPassword.sendKeys("Password");

        WebElement loginButton= driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        loginButton.click();

        WebElement verifyLogin= driver.findElement(By.xpath("(//a[text()='Logout'])[2]"));

        Assert.assertEquals(verifyLogin.getText(),"Logout");

    }
}
