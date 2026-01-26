package com.anhtester.bai20_mutiple_platform.testcases;

import org.testng.annotations.Test;

public class DateTest extends BaseTest {

    @Test
    public void testSwipeAndZoom() {
        loginPage().login("admin", "admin");
        loginPage().verifyLoginSuccess();

    }

}
