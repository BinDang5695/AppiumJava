package pages.TaurusApp;

import drivers.DriverManager;
import keywords.MobileUI;
import utils.LogUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Mobile App Flutter Beta\"]/following-sibling::android.widget.EditText[1]")
    @iOSXCUITFindBy(accessibility = "username")
    private WebElement usernameField;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Mobile App Flutter Beta\"]/following-sibling::android.widget.EditText[2]")
    @iOSXCUITFindBy(accessibility = "password")
    private WebElement passwordField;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Sign in\"]")
    @iOSXCUITFindBy(id = "loginBtn")
    private WebElement loginButton;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'required') or contains(@content-desc,'Invalid')]")
    private List<WebElement> errorMessages;

    public MenuPage login(String username, String password) {
        MobileUI.waitForElementVisible(usernameField);
        MobileUI.clickElement(usernameField);
        MobileUI.setText(usernameField, username);
        MobileUI.waitForElementVisible(passwordField);
        MobileUI.clickElement(passwordField);
        MobileUI.setText(passwordField, password);
        MobileUI.waitForElementVisible(loginButton);
        MobileUI.clickElement(loginButton);
        return new MenuPage();
    }

    public MenuPage verifyLoginSuccess() {
        MobileUI.verifyElementPresentAndDisplayed(menuMenu, "The Table page not display. (Menu not found)");
        return new MenuPage();
    }

    public void verifyLoginFailMessages(String... expectedMessages) {

        MobileUI.waitForElementVisible(errorMessages.get(0));

        LogUtils.info("Actual error messages:");

        List<String> actualMessages = new ArrayList<>();

        for (WebElement error : errorMessages) {
            String msg = MobileUI.getElementAttribute(error, "content-desc");
            actualMessages.add(msg);
            LogUtils.info("Error message: " + msg);
        }

        MobileUI.verifyEquals(String.valueOf(actualMessages.size()), String.valueOf(expectedMessages.length), "Number of error messages is incorrect.");

        for (String expected : expectedMessages) {
            boolean found = actualMessages.contains(expected);

            MobileUI.verifyEquals(String.valueOf(found), String.valueOf(true), "Expected error message not found: " + expected);
        }
    }





}