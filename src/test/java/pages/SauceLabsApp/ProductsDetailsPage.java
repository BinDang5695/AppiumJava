package pages.SauceLabsApp;

import keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ProductsDetailsPage extends BasePage {

    private By buttonGreenColor = AppiumBy.accessibilityId("Green color");
    private By buttonIncreaseItemQuantity = AppiumBy.accessibilityId("Increase item quantity");
    private By buttonAddToCart = AppiumBy.accessibilityId("Tap to add product to cart");

    public void clickButtonGreenColor() {
        MobileUI.clickElement(buttonGreenColor);
    }

    public void clickButtonIncreaseItemQuantity() {
        MobileUI.clickElement(buttonIncreaseItemQuantity);
    }

    public void clickButtonAddToCart() {
        MobileUI.clickElement(buttonAddToCart);
    }

}
