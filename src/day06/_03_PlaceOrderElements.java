package day06;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseDriver;

public class _03_PlaceOrderElements {


    /**
     All elements on this page need drivers connection,
     for this the following constructor has been added and
     all elements on this (this) page are associated via PageFactory and driver.
     Thus, finding the elements is active when the object is used,
     not when the object is derived from the page.
     With this method, if there are elements with the same name on all pages,
     the definition here becomes valid for all of them.
     This structure is called the Page Object Model (POM).
     */

    public _03_PlaceOrderElements() {
        PageFactory.initElements(BaseDriver.driver, this);
        // Make driver.findElement for all.
    }

    @FindBy(css="[placeholder='Search']")
    public WebElement searchBox;

    @FindBy(css = "[class='btn btn-default btn-lg']")
    public WebElement searchButton;

    @FindBy(xpath = "//span[text()='Add to Cart']")
    public WebElement addToCart;

    @FindBy(xpath = "(//span[text()='Shopping Cart'])[1]")
    public WebElement shoppingCart;

    @FindBy(id = "bitnami-close-banner-button")
    public WebElement bannerButton;

    @FindBy(xpath = "//a[text()='Checkout']")
    public WebElement checkoutButton;

    @FindBy(id = "button-payment-address")
    public WebElement continueButton;

    @FindBy(id = "button-shipping-address")
    public WebElement continueButton2;

    @FindBy(id = "button-shipping-method")
    public WebElement continueButton3;

    @FindBy(name="agree")
    public WebElement agree;

    @FindBy(id = "button-payment-method")
    public WebElement continueButton4;

    @FindBy(id = "button-confirm")
    public WebElement confirm;

    @FindBy(xpath = "//div[@id='content']/h1")
    public WebElement messageLabel;
}
