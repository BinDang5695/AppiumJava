package com.anhtester.bai20_mutiple_platform.pages;

import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.MobileUI;
import com.anhtester.utils.LogUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ConfigPage extends BasePage {
    public ConfigPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,\"Product management\")]")
    private WebElement itemProductManagement;

    @AndroidFindBy(accessibility = "Server database")
    private WebElement itemServerDatabase;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,\"Tables management\")]")
    private WebElement itemTableManagement;

    @AndroidFindBy(accessibility = "Server database")
    private WebElement menuServerDatabase;

    @AndroidFindBy(accessibility = "Replace")
    private WebElement buttonReplace;

    @AndroidFindBy(accessibility = "Downloaded")
    private WebElement alertDownloaded;

    @AndroidFindBy(accessibility = "Back")
    private WebElement buttonBack;

    @AndroidFindBy(accessibility = "Logout")
    private WebElement itemLogout;

    public ProductPage openProductManagement() {
        MobileUI.waitForElementVisible(itemProductManagement);
        MobileUI.clickElement(itemProductManagement);
        return new ProductPage();
    }

    public ServerPage openServerDatabase() {
        itemServerDatabase.click();
        return new ServerPage();
    }

    public TablePage openTableManagement() {
        itemTableManagement.click();
        return new TablePage();
    }

    public LoginPage logout() {
        itemLogout.click();
        return new LoginPage();
    }

    private By downloadButtonByData(int dataNumber) {
        return AppiumBy.xpath(
                "//android.view.View[contains(@content-desc,'Data " + dataNumber + "')]" +
                        "//android.widget.Button"
        );
    }

    public void downloadDataFromServer(int dataNumber) {

        MobileUI.waitForElementVisible(menuConfig);
        MobileUI.clickElement(menuConfig);
        MobileUI.waitForElementVisible(menuServerDatabase);
        MobileUI.clickElement(menuServerDatabase);

        MobileUI.waitForElementVisible(downloadButtonByData(dataNumber));
        MobileUI.clickElement(downloadButtonByData(dataNumber));

        MobileUI.waitForElementVisible(buttonReplace);
        MobileUI.clickElement(buttonReplace);

        MobileUI.waitForElementVisible(alertDownloaded);

        LogUtils.info("✅ Database demo Data " + dataNumber + " downloaded");
        MobileUI.waitForElementVisible(buttonBack);
        MobileUI.clickElement(buttonBack);
    }
}