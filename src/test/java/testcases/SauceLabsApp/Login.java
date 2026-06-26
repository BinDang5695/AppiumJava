package testcases.SauceLabsApp;

import common.BaseTestSauceLabs;
import dataproviders.LoginDataProvider;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.LogUtils;

import java.util.Hashtable;


public class Login extends BaseTestSauceLabs {

    @Test
    @Story("Login feature")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify user can login successfully")
    @Link(name = "Login Jira", url = "https://jira.com/anhtester/login")
    public void testLoginSuccess() {
        loginPage().login();
        productsPage().verifyLoginSuccess();
    }

    @Test(dataProvider = "invalidLoginDataJSON", dataProviderClass = LoginDataProvider.class)
    public void testLoginFail(String email, String password, String message, String name) {
        LogUtils.info("Running test case: " + name);
        loginPage().login(email, password);
        loginPage().verifyLoginFailMessages(message);
    }

    @Test(dataProvider = "loginExcelData", dataProviderClass = LoginDataProvider.class)
    public void testLoginWithExcelFile(Hashtable<String, String> data) {
        String username = data.get("USERNAME");
        String password = data.get("PASSWORD");
        String message = data.get("MESSAGE");

        LogUtils.info("USERNAME = " + username);
        LogUtils.info("PASSWORD = " + password);
        LogUtils.info("MESSAGE = " + message);
        loginPage().login(username, password);
        if (message  == null || message.trim().isEmpty()) {

            productsPage().verifyLoginSuccess();

        } else {

            loginPage().verifyLoginFailMessages(message);
        }
    }

    @Test
    public void testLoginWithSoftAssert() {

        SoftAssert softAssert = new SoftAssert();
        basePage().clickButtonViewMenu();
        basePage().clickButtonLogin();
        loginPage().verifyLoginPage(softAssert);
        softAssert.assertAll();
    }
}