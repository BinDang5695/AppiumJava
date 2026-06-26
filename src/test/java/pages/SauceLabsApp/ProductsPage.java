package pages.SauceLabsApp;

import keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ProductsPage extends BasePage {

    private By itemSauceLabsBackpack = AppiumBy.xpath("(//android.widget.ImageView[@content-desc=\"Product Image\"])[1]");
    private By titleProducts = AppiumBy.accessibilityId("title");

    public void verifyLoginSuccess() {
        MobileUI.verifyElementPresentAndDisplayed(titleProducts, "Can't login, title Products is not found");
    }

    public void clickSauceLabsBackpack() {
        MobileUI.clickElement(itemSauceLabsBackpack);
    }

}
