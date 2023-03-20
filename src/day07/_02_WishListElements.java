package day07;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseDriver;

import java.util.List;

public class _02_WishListElements {

    public _02_WishListElements() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(css="div[class='caption']>h4>a")
    List<WebElement> searchResults;
    @FindBy(xpath="//button[@data-original-title='Add to Wish List']")
    List<WebElement> wishLists;
    @FindBy(id="wishlist-total")
    WebElement wishProductsButton;
    @FindBy(css="[class='text-left']>a")
    List<WebElement> wishTableNames;
}
