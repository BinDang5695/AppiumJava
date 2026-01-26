package com.anhtester.bai18_pagenavigation.testcases;

import com.anhtester.bai18_pagenavigation.pages.ConfigPage;
import com.anhtester.bai18_pagenavigation.pages.LoginPage;
import com.anhtester.bai18_pagenavigation.pages.MenuPage;
import com.anhtester.bai18_pagenavigation.pages.ProductPage;
import com.anhtester.common.BaseTestTaurusApp;
import org.testng.annotations.Test;

public class ProductTest extends BaseTestTaurusApp {

    private LoginPage loginPage;
    private MenuPage menuPage;
    private ConfigPage configPage;
    private ProductPage productPage;

    @Test
    public void testAddNewProduct() {
        loginPage = new LoginPage();

        menuPage = loginPage.login("admin", "admin");
        configPage = menuPage.openConfigPage();
        productPage = configPage.openProductManagement();
        productPage.addNewProduct("Create a new Product", 123);
        productPage.verifyAddedProduct("Create a new Product", 123);
        productPage.deleteAddedProduct("Create a new Product", 123);

    }
}