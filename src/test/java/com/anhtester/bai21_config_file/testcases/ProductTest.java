package com.anhtester.bai21_config_file.testcases;

import com.anhtester.bai21_config_file.pages.ConfigPage;
import com.anhtester.bai21_config_file.pages.LoginPage;
import com.anhtester.bai21_config_file.pages.ProductPage;
import com.anhtester.bai20_mutiple_platform.testcases.BaseTest;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    private LoginPage loginPage;
    private ConfigPage configPage;
    private ProductPage productPage;

    @Test
    public void testAddNewProduct() {
        loginPage = new LoginPage();
        loginPage.login("admin", "admin");

        configPage = new ConfigPage();
        productPage = configPage.openProductManagement();

        //productPage = new ProductPage();
        productPage.addNewProduct();
    }
}