package pages.SauceLabsApp;

import model.Payment;
import keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class CheckoutPage {

    private By fieldFullName = AppiumBy.id("com.saucelabs.mydemoapp.android:id/fullNameET");
    private By fieldAddressLine1 = AppiumBy.id("com.saucelabs.mydemoapp.android:id/address1ET");
    private By fieldAddressLine2 = AppiumBy.id("com.saucelabs.mydemoapp.android:id/address2ET");
    private By fieldCity = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cityET");
    private By fieldZipCode = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/zipET\"]");
    private By fieldCountry = AppiumBy.id("com.saucelabs.mydemoapp.android:id/countryET");
    private By buttonToPayment = AppiumBy.accessibilityId("Saves user info for checkout");
    private By fieldFullNameCard = AppiumBy.id("com.saucelabs.mydemoapp.android:id/nameET");
    private By fieldCardNumber = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cardNumberET");
    private By fieldExpirationDate = AppiumBy.id("com.saucelabs.mydemoapp.android:id/expirationDateET");
    private By fieldSecurityCode = AppiumBy.id("com.saucelabs.mydemoapp.android:id/securityCodeET");
    private By buttonReviewOrder = AppiumBy.accessibilityId("Saves payment info and launches screen to review checkout data");
    private By buttonPlaceOrder = AppiumBy.accessibilityId("Completes the process of checkout");
    private By checkoutComplete = AppiumBy.id("com.saucelabs.mydemoapp.android:id/completeTV");

    public void enterAShippingAddress(Payment data) {
        MobileUI.setText(fieldFullName, data.getFullName());
        MobileUI.setText(fieldAddressLine1, data.getAddressLine1());
        MobileUI.setText(fieldAddressLine2, data.getAddressLine2());
        MobileUI.setText(fieldCity, data.getCity());
        MobileUI.setText(fieldZipCode, data.getZipCode());
        MobileUI.setText(fieldCountry, data.getCountry());
        MobileUI.clickElement(buttonToPayment);
    }

    public void enterAPaymentMethod(Payment data) {
        MobileUI.setText(fieldFullNameCard, data.getCardName());
        MobileUI.setText(fieldCardNumber, data.getCardNumber());
        MobileUI.setText(fieldExpirationDate, data.getExpirationDate());
        MobileUI.setText(fieldSecurityCode, data.getSecurityCode());
        MobileUI.clickElement(buttonReviewOrder);
    }

    public void clickButtonPlaceOrder() {
        MobileUI.clickElement(buttonPlaceOrder);
    }

    public void verifyPaymentSuccess() {
        MobileUI.getElementText(checkoutComplete, "Checkout Complete", "Checkout incomplete");
    }




}
