package com.anhtester.bai21_config_file.testcases;

import com.anhtester.bai21_config_file.pages.LoginPage;
import com.anhtester.bai21_config_file.pages.MenuPage;
import com.anhtester.bai20_mutiple_platform.testcases.BaseTest;
import org.testng.annotations.Test;

public class MenuTest extends BaseTest {

    LoginPage loginPage;
    MenuPage menuPage;

    @Test
    public void testSearchTable() {
        loginPage = new LoginPage();
        //Khởi tạo trang Menu thông qua việc Login nếu thành công
        menuPage = loginPage.login("admin", "admin");
        loginPage.verifyLoginSuccess();

        configPage().downloadDataFromServer(4);

        //menuPage = new MenuPage(); //không cần khởi tạo trang Menu riêng
        menuPage.searchTable("Table 1");
        menuPage.checkTableResultTotal(2);
    }
}