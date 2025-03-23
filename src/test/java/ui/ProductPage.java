package ui;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage {
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    // Constructor
    public ProductPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private WebElement getProduct() {
        return wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Sauce Lab Back Packs']"))
        ));
    }

    private WebElement getColor() {
        return wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Blue color']"))
        ));
    }

    private WebElement getIncreaseQuantityButton() {
        return driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Increase item quantity']"));
    }

    private WebElement getAddToCartButton() {
        return driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Tap to add product to cart']"));
    }

    private WebElement getCheckoutCart() {
        return driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Displays number of items in your cart']"));
    }

    private WebElement getCheckoutButton() {
        return driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Confirms products for checkout']"));
    }

    // Actions
    public void selectProduct() {
        getProduct().click();
    }

    public void selectColor() {
        getColor().click();
    }

    public void setQuantity(int quantity) {
        int clicks = quantity - 1; // Because default is 1
        for (int i = 0; i < clicks; i++) {
            getIncreaseQuantityButton().click();
        }
    }

    public void addToCart() {
        getAddToCartButton().click();
    }

    public void goToCart() {
        getCheckoutCart().click();
    }

    public void proceedToCheckout() {
        getCheckoutButton().click();
    }
}
