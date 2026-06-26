package pages.SauceLabsApp;

import keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class DrawingPage {

    private By buttonAllow = AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button");

    public void clickButtonAllow() {
        MobileUI.clickElement(buttonAllow);
    }

    public void drawLine() {
        MobileUI.sleep(5);
        MobileUI.drawLine(500, 1000, 700, 1200);
    }

}
