package com.anhtester.bai17_pageobjectmodel.testcases;

import com.anhtester.bai17_pageobjectmodel.pages.LoginPage;
import com.anhtester.bai17_pageobjectmodel.pages.MenuPage;
import com.anhtester.common.BaseTestTaurusApp;
import org.testng.annotations.Test;

public class MenuTest extends BaseTestTaurusApp {

    LoginPage loginPage;
    MenuPage menuPage;

    @Test
    public void testSearchTable() {
        loginPage = new LoginPage();

        loginPage.login("admin", "admin");
        loginPage.verifyLoginSuccess();

        downloadDataFromServer(2);

        menuPage = new MenuPage();

        menuPage.searchTable("Table 1");
        menuPage.checkTableResultTotal(1);
    }
}
