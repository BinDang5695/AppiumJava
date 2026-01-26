package com.anhtester.bai20_mutiple_platform.pages;

import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.MobileUI;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    //Constructor bắt buộc để init elements
    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }
    private LoginPage loginPage;
    private ConfigPage configPage;
    private ProductPage productPage;
    private MenuPage menuPage;
    private DatePage datePage;
    private OrderPage orderPage;
    private ProfilePage profilePage;

    @AndroidFindBy(accessibility = "Date")
    @iOSXCUITFindBy(accessibility = "Date")
    public WebElement menuDate;

    @AndroidFindBy(accessibility = "Menu")
    @iOSXCUITFindBy(accessibility = "Menu")
    public WebElement menuMenu;

    @AndroidFindBy(accessibility = "Wallet")
    @iOSXCUITFindBy(accessibility = "Wallet")
    public WebElement menuWallet;

    @AndroidFindBy(accessibility = "Profile")
    @iOSXCUITFindBy(accessibility = "Profile")
    public WebElement menuProfile;

    @AndroidFindBy(accessibility = "Config")
    @iOSXCUITFindBy(accessibility = "Config")
    public WebElement menuConfig;

    @AndroidFindBy(accessibility = "Open navigation menu")
    @iOSXCUITFindBy(accessibility = "Open navigation menu")
    public WebElement openNavigationLeftMenu;

    @AndroidFindBy(accessibility = "Web view")
    @iOSXCUITFindBy(accessibility = "Web view")
    public WebElement itemWebView;

    @AndroidFindBy(accessibility = "Back")
    @iOSXCUITFindBy(accessibility = "Back")
    public WebElement buttonBack;

    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public ConfigPage configPage() {
        if (configPage == null) {
            configPage = new ConfigPage();
        }
        return configPage;
    }

    public ProductPage productPage() {
        if (productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }

    public MenuPage menuPage() {
        if (menuPage == null) {
            menuPage = new MenuPage();
        }
        return menuPage;
    }

    public DatePage datePage() {
        if (datePage == null) {
            datePage = new DatePage();
        }
        return datePage;
    }

    public OrderPage orderPage() {
        if (orderPage == null) {
            orderPage = new OrderPage();
        }
        return orderPage;
    }

    public ProfilePage profilePage() {
        if (profilePage == null) {
            profilePage = new ProfilePage();
        }
        return profilePage;
    }

    //Các hàm xử lý chung cho nhiều trang đều có
    public void clickMenuDate() {
        MobileUI.waitForElementVisible(menuDate);
        MobileUI.clickElement(menuDate);
    }

    public void clickMenuMenu() {
        MobileUI.waitForElementVisible(menuMenu);
        MobileUI.clickElement(menuMenu);
    }

    public void clickMenuWallet() {
        MobileUI.waitForElementVisible(menuWallet);
        MobileUI.clickElement(menuWallet);
    }

    public void clickMenuProfile() {
        MobileUI.waitForElementVisible(menuProfile);
        MobileUI.clickElement(menuProfile);
    }

    public void clickMenuConfig() {
        MobileUI.waitForElementVisible(menuConfig);
        MobileUI.clickElement(menuConfig);
    }

    public void clickOpenNavigationLeftMenu() {
        MobileUI.waitForElementVisible(openNavigationLeftMenu);
        MobileUI.clickElement(openNavigationLeftMenu);
    }

    public void clickItemWebView() {
        MobileUI.waitForElementVisible(itemWebView);
        MobileUI.clickElement(itemWebView);
    }

    public void clickButtonBack() {
        MobileUI.waitForElementVisible(buttonBack);
        MobileUI.clickElement(buttonBack);
    }

}