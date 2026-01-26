package com.anhtester.bai23_excel_file.testcases;

import com.anhtester.bai23_excel_file.pages.ConfigPage;
import com.anhtester.bai23_excel_file.pages.LoginPage;
import com.anhtester.bai23_excel_file.pages.ProductPage;
import com.anhtester.common.BaseTest_Json_Device;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest_Json_Device {

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