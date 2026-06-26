package pages.SauceLabsApp;

import drivers.AndroidDriverManager;
import drivers.DriverManager;
import keywords.MobileUI;
import utils.LogUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.NoSuchElementException;

public class BasePage {

    private BasePage basePage;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private ProductsDetailsPage productsDetailsPage;
    private MyCartPage myCartPage;
    private CheckoutPage checkoutPage;
    private WebViewPage webViewPage;
    private DrawingPage drawingPage;

    public BasePage basePage() {
        if (basePage == null) {
            basePage = new BasePage();
        }
        return basePage;
    }

    public WebElement find(By locator) {
        return DriverManager.getDriver().findElement(locator);
    }

    public List<WebElement> finds(By locator) {
        return DriverManager.getDriver().findElements(locator);
    }

    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public ProductsPage productsPage() {
        if (productsPage == null) {
            productsPage = new ProductsPage();
        }
        return productsPage;
    }

    public ProductsDetailsPage productsDetailsPage() {
        if (productsDetailsPage == null) {
            productsDetailsPage = new ProductsDetailsPage();
        }
        return productsDetailsPage;
    }

    public MyCartPage myCartPage() {
        if (myCartPage == null) {
            myCartPage = new MyCartPage();
        }
        return myCartPage;
    }

    public CheckoutPage checkoutPage() {
        if (checkoutPage == null) {
            checkoutPage = new CheckoutPage();
        }
        return checkoutPage;
    }

    public WebViewPage webViewPage() {
        if (webViewPage == null) {
            webViewPage = new WebViewPage();
        }
        return webViewPage;
    }

    public DrawingPage drawingPage() {
        if (drawingPage == null) {
            drawingPage = new DrawingPage();
        }
        return drawingPage;
    }

    private By numberOfItemsInYourCart = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartTV");
    private By cart = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartIV");
    private By buttonViewMenu = AppiumBy.accessibilityId("View menu");
    private By buttonWebView = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemTV\" and @text=\"WebView\"]");
    private By buttonDrawing = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemTV\" and @text=\"Drawing\"]");
    private By itemLoginMenu = AppiumBy.accessibilityId("Login Menu Item");
    private By notificationTitle = AppiumBy.id("android:id/title");
    private By notificationDescription = AppiumBy.id("android:id/text");

    public void verifyNumberOfItemsInYourCart(int expectedCount)
    {
        String text = MobileUI.getElementText(numberOfItemsInYourCart);
        int actualCount = Integer.parseInt(text.replaceAll("\\D+", ""));
        Assert.assertEquals(actualCount, expectedCount,
                "Total Products is wrong. Actual text: " + text);
    }

    public void clickCart() {
        MobileUI.clickElement(cart);
    }

    public void clickButtonLogin() {
        MobileUI.clickElement(itemLoginMenu);
    }

    public void clickButtonViewMenu() {
        MobileUI.clickElement(buttonViewMenu);
    }

    public void clickButtonWebView() {
        MobileUI.clickElement(buttonWebView);
    }

    public void clickButtonDrawing() {
        MobileUI.clickElement(buttonDrawing);
    }

    public void handleNotification() {

        AndroidDriverManager.getDriver().openNotifications();

        List<WebElement> notifications = finds(notificationTitle);

        LogUtils.info("List of titles in the notification:");
        for (WebElement notification : notifications) {
            LogUtils.info(notification.getText());
        }

        MobileUI.sleep(2);

        List<WebElement> descriptions = finds(notificationDescription);

        LogUtils.info("List of descriptions in the notification:");
        for (WebElement description : descriptions) {
            try {
                LogUtils.info(description.getText());
            } catch (NoSuchElementException e) {
                LogUtils.info("*** No description found for this message.");
            }
        }

        AndroidDriverManager.getDriver().pressKey(
                new KeyEvent(AndroidKey.BACK)
        );
        MobileUI.sleep(1);
    }

}