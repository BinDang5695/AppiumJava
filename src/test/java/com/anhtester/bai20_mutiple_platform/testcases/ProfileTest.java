package com.anhtester.bai20_mutiple_platform.testcases;

import org.testng.annotations.Test;

public class ProfileTest extends BaseTest {

    @Test
    public void editProfileAndVerify() {
        loginPage().login("admin", "admin");
        loginPage().verifyLoginSuccess();
        basePage().clickMenuProfile();
        profilePage().editProfile();
        loginPage().login("admin", "adminbindz");
        loginPage().verifyLoginSuccess();
        basePage().clickMenuProfile();
        profilePage().verifyEditedProfile();
    }
}
