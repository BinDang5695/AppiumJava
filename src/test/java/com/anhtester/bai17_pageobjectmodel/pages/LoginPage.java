package com.anhtester.bai17_pageobjectmodel.pages;
import com.anhtester.drivers.DriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class LoginPage {

    // Constructor
    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    //Element/Locators thuộc chính trang này (màn hình này)
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Mobile App Flutter Beta\"]/following-sibling::android.widget.EditText[1]")
    @iOSXCUITFindBy(accessibility = "username")
    private WebElement usernameField;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Mobile App Flutter Beta\"]/following-sibling::android.widget.EditText[2]")
    @iOSXCUITFindBy(accessibility = "password")
    private WebElement passwordField;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Sign in\"]")
    @iOSXCUITFindBy(id = "loginBtn")
    private WebElement loginButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc[contains(.,'Invalid') or contains(.,'required')]]")
    private List<WebElement> allErrorMessages;

    @AndroidFindBy(accessibility = "Menu")
    @iOSXCUITFindBy(accessibility = "Menu")
    private WebElement menuHome;

    //Các hàm xử lý trong chính nội bộ trang này (màn hình này)
    public void login(String username, String password) {
        usernameField.click();
        usernameField.sendKeys(username);
        passwordField.click();
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void forgotPassword(String email) {
        //Xử lý auto forgot password
        System.out.println("Forgot password success");
    }


    public void verifyRedirectToLoginPage() {
        //Kiểm tra cái header hiển thị
        //Web: kiểm tra url chứa text gì đó "/login"
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(menuHome.isDisplayed(), "The Table page not display. (Menu not found)");
    }

    public void verifyLoginFail(String expectedMessage) {
        String actualMessage = getDisplayedErrorMessage();
        System.out.println("📩 Error message actual: " + actualMessage);
        Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(), "❌ Error message content mismatch.");
    }

    public String getDisplayedErrorMessage() {

        List<String> messages = new ArrayList<>();
        for (WebElement element : allErrorMessages) {
            try {
                if (element.isDisplayed()) {
                    String text = element.getAttribute("content-desc");
                    if (text != null && !text.trim().isEmpty()) {
                        messages.add(text.trim());
                    }
                }
            } catch (Exception ignored) {}
        }

        if (messages.isEmpty()) {
            throw new AssertionError("❌ No error message found on Login screen!");
        }

        return messages.get(0);
    }
}
