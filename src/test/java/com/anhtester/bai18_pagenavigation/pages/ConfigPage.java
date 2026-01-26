package com.anhtester.bai18_pagenavigation.pages;

import com.anhtester.drivers.DriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ConfigPage {
    public ConfigPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc, 'Product management')]")
    @iOSXCUITFindBy(accessibility = "Product management")
    private WebElement productManagementItem;

    public ProductPage openProductManagement() {
        productManagementItem.click();

        return new ProductPage();
    }

}