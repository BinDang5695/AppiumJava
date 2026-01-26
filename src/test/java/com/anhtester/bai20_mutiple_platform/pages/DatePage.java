package com.anhtester.bai20_mutiple_platform.pages;

import com.anhtester.drivers.DriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DatePage extends BasePage {

    public DatePage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText")
    @iOSXCUITFindBy(accessibility = "")
    private WebElement inputSearch;

    @AndroidFindBy(xpath = "(//android.view.View[contains(@content-desc,\"Table\")])[1]")
    @iOSXCUITFindBy(accessibility = "")
    private WebElement firstItemTable;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Table\")]")
    @iOSXCUITFindBy(xpath = "")
    private List<WebElement> listItemTable;



}
