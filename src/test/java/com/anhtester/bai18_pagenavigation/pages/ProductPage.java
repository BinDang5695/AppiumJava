package com.anhtester.bai18_pagenavigation.pages;

import com.anhtester.drivers.DriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductPage {
    public ProductPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Add Product\"]")
    @iOSXCUITFindBy(accessibility = "Add Product")
    private WebElement buttonAddProduct;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[1]")
    @iOSXCUITFindBy(accessibility = "")
    private WebElement inputName;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[2]")
    @iOSXCUITFindBy(accessibility = "Config")
    private WebElement inputPrice;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Save\"]")
    @iOSXCUITFindBy(accessibility = "Save")
    private WebElement buttonSave;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Create a new Product\"]")
    @iOSXCUITFindBy(accessibility = "Create a new Product")
    private WebElement productNameCreated;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Price: 123\"]")
    @iOSXCUITFindBy(accessibility = "Price: 123")
    private WebElement productPriceCreated;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button[2]")
    @iOSXCUITFindBy(accessibility = "Price: 123")
    private WebElement buttonEdit;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Del\"]")
    @iOSXCUITFindBy(accessibility = "Price: 123")
    private WebElement buttonDelete;

    public ProductPage addNewProduct(String productName, int productPrice) {

        buttonAddProduct.click();
        inputName.click();
        inputName.sendKeys(productName);
        inputPrice.click();
        inputPrice.sendKeys(String.valueOf(productPrice));
        buttonSave.click();
        return new ProductPage();
    }

    public ProductPage verifyAddedProduct(String productName, int productPrice) {

        Assert.assertTrue(productNameCreated.isDisplayed(), "The productNameCreated not display.");
        Assert.assertTrue(productPriceCreated.isDisplayed(), "The productPriceCreated not display.");
        System.out.println(productNameCreated.getAttribute("content-desc"));
        Assert.assertEquals(productNameCreated.getAttribute("content-desc"), "Create a new Product", "The content of error message not display.");
        System.out.println(productPriceCreated.getAttribute("content-desc"));
        Assert.assertEquals(productPriceCreated.getAttribute("content-desc"), "Price: 123", "The content of error message not display.");
        return new ProductPage();
    }

    public ProductPage deleteAddedProduct(String productName, int productPrice) {

        buttonEdit.click();
        buttonDelete.click();
        return new ProductPage();
    }

}