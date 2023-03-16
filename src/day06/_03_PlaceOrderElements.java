package day06;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseDriver;

public class _03_PlaceOrderElements {

    // Bu sayfadaki bütün elemenalrın driverlar bağlantısı gerekiyor
    // bunun için aşağıdaki constructor eklendi ve PageFactory ile
    // driver üzerinden bu (this) sayfadaki bütün elemanlar ilişkilendirildi.
    // Böylece sayfadan nesne türetildiği zaman değil kullanıldığı
    // anda elemanların bulunması aktif oluyor. Bu yöntemle bütün sayfalarda
    // aynı isimde elemanlar var ise buradaki tanımlama hepsi için geçerli hale
    // gelmiş oluyor. buna yapıya Page Object Model (POM) adı veriliyor.


    public _03_PlaceOrderElements() {
        PageFactory.initElements(BaseDriver.driver, this);
        // driver.findElement'i hepsi için yap.
    }

    @FindBy(name="search")
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
