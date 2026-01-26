package com.anhtester.bai20_mutiple_platform.testcases;

import org.testng.annotations.Test;

public class MenuTest extends BaseTest {


    @Test
    public void testSearchTable() {
        loginPage().login("admin", "admin");
        loginPage().verifyLoginSuccess();
        configPage().downloadDataFromServer(4);
        menuPage().searchTable("Table 1");
        menuPage().checkTableResultTotal(1);
    }
}