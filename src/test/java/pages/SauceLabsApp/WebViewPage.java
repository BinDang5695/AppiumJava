package pages.SauceLabsApp;

import keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class WebViewPage extends BasePage {

    private By inputURL = AppiumBy.id("com.saucelabs.mydemoapp.android:id/urlET");
    private By buttonGoToSite = AppiumBy.accessibilityId("Tap to view content of given url");
    private By clickSearch = AppiumBy.xpath("(//android.widget.Button[@text=\"Search YouTube\"])[1]");
    private By inputSearch = AppiumBy.xpath("//android.widget.EditText");
    private By optionSonTung = AppiumBy.xpath("//android.widget.Button[@text=\"son tung\"]");
    private By albumComeMyWay = AppiumBy.accessibilityId("Come My Way");
    private By paste = AppiumBy.id("com.saucelabs.mydemoapp.android:id/urlTV");

    public void inputURL() {
        MobileUI.setText(inputURL, "https://www.youtube.com");
    }

    public void clickInputURL() {
        MobileUI.setText(inputURL, "https://www.youtube.com");
    }

    public void clickButtonGoToSite() {
        MobileUI.clickElement(buttonGoToSite);
    }

    public void inputSearch() {
        MobileUI.waitForElementVisible(clickSearch);
        MobileUI.clickElement(clickSearch);
        MobileUI.setText(inputSearch, "son tung");
    }

    public void clickOptionSonTung() {
        MobileUI.clickElement(optionSonTung);
    }

    public void scrollOnYTB() {
        MobileUI.sleep(5);
        MobileUI.scrollDown();
    }

    public void swipeOnYTB() {
        MobileUI.swipeElementRightToLeft(albumComeMyWay, 1000);
    }

    public void tapOnYTB() {
        MobileUI.sleep(5);
        MobileUI.tap(500, 1000);
    }

    public void longPress() {
        MobileUI.longPress(inputURL, 3000);
    }




}
