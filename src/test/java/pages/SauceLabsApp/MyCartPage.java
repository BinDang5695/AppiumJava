package pages.SauceLabsApp;

import keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class MyCartPage {

    private By buttonProceedToCheckout = AppiumBy.accessibilityId("Confirms products for checkout");

    public void clickButtonProceedToCheckout() {
        MobileUI.clickElement(buttonProceedToCheckout);
    }


}
