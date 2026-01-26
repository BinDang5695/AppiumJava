package com.anhtester.bai20_mutiple_platform.testcases;

import org.testng.annotations.Test;

public class OrderTest extends BaseTest {

    @Test
    public void addOrderAndPayment() {
        loginPage().login("admin", "admin");
        basePage().clickMenuConfig();
        configPage().downloadDataFromServer(4);
        basePage().clickMenuMenu();
        orderPage().addNewOrder();
        basePage().clickButtonBack();
        basePage().clickMenuDate();
        orderPage().verifyPaymentSuccess();
    }

    @Test
    public void addOrderThenUpdateAndPayment() {
        loginPage().login("admin", "admin");
        basePage().clickMenuConfig();
        configPage().downloadDataFromServer(4);
        basePage().clickMenuMenu();
        orderPage().addNewAndUpdatedOrder();
        basePage().clickButtonBack();
        basePage().clickMenuDate();
        orderPage().verifyPaymentSuccessAfterUpdated();
    }
}