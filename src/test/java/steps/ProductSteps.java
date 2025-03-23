package steps;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ui.ProductPage;
import utils.BaseTest;

public class ProductSteps extends BaseTest {
    ProductPage productPage;

    @Given("User opens the app")
    public void userOpensTheApp() {
        setup();  // Call setup from BaseTest
        productPage = new ProductPage(driver);
    }

    @When("User selects Sauce Lab Back Packs")
    public void userSelectsProduct() {
        productPage.selectProduct();
    }

    @And("User selects blue color")
    public void userSelectsColor() {
        productPage.selectColor();
    }

    @And("User sets quantity to {int}")
    public void userSetsQuantity(int quantity) {
        productPage.setQuantity(quantity);
    }

    @And("User adds product to cart")
    public void userAddsToCart() {
        productPage.addToCart();
    }

    @And("User proceeds to checkout")
    public void userProceedsToCheckout() {
        productPage.goToCart();

    }

    @Then("User should see product title {string} and total price {double}")
    public void userVerifiesProductAndPrice(String expectedTitle, double expectedPrice) {
        try {
            String actualTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/titleTV']"))
                    .getText().trim();  // Trim to remove extra spaces

            String priceText = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/priceTV']"))
                    .getText().replace("$", "").trim();
            double itemPrice = Double.parseDouble(priceText);

            String quantityText = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/noTV']"))
                    .getText().trim();
            int quantity = Integer.parseInt(quantityText);

            double actualTotalPrice = itemPrice * quantity;

            Assert.assertEquals(actualTitle, expectedTitle, "❌ Product title mismatch! Expected: " + expectedTitle + " | Actual: " + actualTitle);

            Assert.assertEquals(actualTotalPrice, expectedPrice, 0.01);
            productPage.proceedToCheckout();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("❌ Error verifying product details: " + e.getMessage());
        }
    }

}
