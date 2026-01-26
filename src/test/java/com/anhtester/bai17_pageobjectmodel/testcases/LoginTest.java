package com.anhtester.bai17_pageobjectmodel.testcases;

import com.anhtester.bai17_pageobjectmodel.pages.LoginPage;
import com.anhtester.common.BaseTestTaurusApp;
import org.testng.annotations.Test;

public class LoginTest extends BaseTestTaurusApp {

    private LoginPage loginPage;

    @Test(priority = 1)
    public void testLoginSuccess() {

        loginPage = new LoginPage();

        loginPage.login("admin", "admin");

        loginPage.verifyLoginSuccess();
    }

    @Test(priority = 2)
    public void testLoginFailWithInvalidEmail() {

        loginPage = new LoginPage();

        loginPage.login("admin123", "admin");

        loginPage.verifyLoginFail(" Invalid email or password");
    }

    @Test(priority = 3)
    public void testLoginFailWithInvalidPassword() {

        loginPage = new LoginPage();

        loginPage.login("admin", "admin789");

        loginPage.verifyLoginFail(" Invalid email or password");
    }

    @Test(priority = 4)
    public void testLoginFailWithBlankEmail() {

        loginPage = new LoginPage();

        loginPage.login("", "admin");

        loginPage.verifyLoginFail("Email is required");
    }

    @Test(priority = 5)
    public void testLoginFailWithBlankPassword() {

        loginPage = new LoginPage();

        loginPage.login("admin", "");

        loginPage.verifyLoginFail("Password is required");
    }
}