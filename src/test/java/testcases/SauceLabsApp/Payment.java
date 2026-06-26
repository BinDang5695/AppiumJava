package testcases.SauceLabsApp;

import common.BaseTestSauceLabs;
import dataproviders.CheckoutDataProvider;
import org.testng.annotations.Test;

public class Payment extends BaseTestSauceLabs {

    @Test
    public void addProductsToCart() {
        loginPage().login("bod@example.com", "10203040");
        productsPage().clickSauceLabsBackpack();
        productsDetailsPage().clickButtonGreenColor();
        productsDetailsPage().clickButtonIncreaseItemQuantity();
        productsDetailsPage().clickButtonAddToCart();
        basePage().verifyNumberOfItemsInYourCart(2);
    }

    @Test(dataProvider = "checkoutDataJSON", dataProviderClass = CheckoutDataProvider.class)
    public void paymentSuccess(model.Payment data) {
        loginPage().login("bod@example.com", "10203040");
        productsPage().clickSauceLabsBackpack();
        productsDetailsPage().clickButtonGreenColor();
        productsDetailsPage().clickButtonIncreaseItemQuantity();
        productsDetailsPage().clickButtonAddToCart();
        basePage().verifyNumberOfItemsInYourCart(2);
        productsDetailsPage().clickCart();
        myCartPage().clickButtonProceedToCheckout();
        checkoutPage().enterAShippingAddress(data);
        checkoutPage().enterAPaymentMethod(data);
        checkoutPage().clickButtonPlaceOrder();
        checkoutPage().verifyPaymentSuccess();
    }
}
