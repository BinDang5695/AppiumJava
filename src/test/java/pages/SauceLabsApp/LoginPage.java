package pages.SauceLabsApp;

import drivers.DriverManager;
import helpers.PropertiesHelpers;
import keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(
                new AppiumFieldDecorator(DriverManager.getDriver()),
                this
        );
    }

    private By fieldUsername = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]");
    private By fieldPassword = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/passwordET\"]");
    private By buttonLogin = AppiumBy.xpath("//android.widget.Button[@content-desc=\"Tap to login with given credentials\"]");
    private By errorMessages = AppiumBy.xpath("//android.widget.TextView[contains(@resource-id,'ErrorTV')]");
    private By headerLoginPage = AppiumBy.id("com.saucelabs.mydemoapp.android:id/loginTV");

    public void login() {
        basePage().clickButtonViewMenu();
        basePage().clickButtonLogin();
        MobileUI.setText(fieldUsername, PropertiesHelpers.getValue("USERNAME"));
        MobileUI.clickElement(fieldPassword);
        MobileUI.setText(fieldPassword, PropertiesHelpers.getValue("PASSWORD"));
        MobileUI.clickElement(buttonLogin);
    }

    public void login(String email, String password) {
        basePage().clickButtonViewMenu();
        basePage().clickButtonLogin();
        MobileUI.setText(fieldUsername, email);
        MobileUI.setText(fieldPassword, password);
        MobileUI.clickElement(buttonLogin);
    }

    public void verifyLoginFailMessages(String... expected) {

        List<WebElement> elements = finds(errorMessages);

        List<String> actual = elements.stream()
                .map(e -> e.getText().trim())
                .toList();

        for (String exp : expected) {
            Assert.assertTrue(
                    actual.stream().anyMatch(a -> a.contains(exp)),
                    "Not found: " + exp
            );
        }
    }

    public void verifyLoginPage(SoftAssert softAssert) {

        WebElement header = find(headerLoginPage);
        softAssert.assertFalse(
                header.isDisplayed(),
                "Header Login page not display."
        );

        softAssert.assertEquals(
                header.getText(),
                "Login123",
                "Login header text not match."
        );

        WebElement button = find(buttonLogin);
        softAssert.assertFalse(
                button.isDisplayed(),
                "Button Login page not display."
        );

        softAssert.assertEquals(
                button.getText(),
                "Login321",
                "Button Login text not match."
        );
    }







}