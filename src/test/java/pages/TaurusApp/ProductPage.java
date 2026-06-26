package pages.TaurusApp;

import drivers.DriverManager;
import keywords.MobileUI;
import utils.LogUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {
    public ProductPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    @AndroidFindBy(accessibility = "Add Product")
    @iOSXCUITFindBy(accessibility = "Add Product")
    private WebElement buttonAddNewProduct;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    @iOSXCUITFindBy(xpath = "")
    private WebElement inputSearchProduct;

    @AndroidFindBy(uiAutomator =
            "new UiSelector().className(\"android.widget.EditText\").instance(0)")
    private WebElement inputName;

    @AndroidFindBy(uiAutomator =
            "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    private WebElement inputPrice;

    @AndroidFindBy(uiAutomator = "new UiSelector()" + ".className(\"android.widget.Switch\")" + ".checkable(true)")
    private WebElement switchHiddenProduct;

    @AndroidFindBy(accessibility = "Save")
    @iOSXCUITFindBy(accessibility = "Save")
    private WebElement buttonSave;

    private WebElement getProductNameByText(String name) {
        return DriverManager.getDriver().findElement(
                AppiumBy.xpath("//android.view.View[@content-desc=\"" + name + "\"]")
        );
    }

    private WebElement getProductPriceByText(String fullPriceText) {
        return DriverManager.getDriver().findElement(
                AppiumBy.xpath("//android.view.View[@content-desc=\"" + fullPriceText + "\"]")
        );
    }

    @AndroidFindBy(uiAutomator =
            "new UiSelector().className(\"android.widget.Button\").index(4)")
    private WebElement iconEdit;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"bin123\"]")
    private WebElement inputEditName;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"123\"]")
    private WebElement inputEditPrice;

    @AndroidFindBy(accessibility = "Del")
    private WebElement buttonDelete;

    @AndroidFindBy(xpath = "//android.widget.ImageView")
    private WebElement imageNoResultFound;

    public void addNewProduct() {
        MobileUI.waitForElementVisible(buttonAddNewProduct);
        LogUtils.info("Add new product");
        MobileUI.clickElement(buttonAddNewProduct);
        MobileUI.setText(inputName, "Bin Product");
        MobileUI.setText(inputPrice, "1000");
        //MobileUI.clickElement(switchHiddenProduct);
        MobileUI.waitForElementVisible(buttonSave);
        MobileUI.clickElement(buttonSave);
    }

    public void verifyAddedProduct() {
        MobileUI.waitForElementVisible(inputSearchProduct);
        LogUtils.info("Search and verify added Product");
        MobileUI.setText(inputSearchProduct, "Bin Product");
        MobileUI.verifyElementContentDesc(getProductNameByText("Bin Product"), "Bin Product", "Product name incorrect");
        MobileUI.verifyElementContentDesc(getProductPriceByText("Price: 1000"), "Price: 1000", "Product price incorrect");
    }

    public void updateProduct() {
        MobileUI.waitForElementVisible(inputSearchProduct);
        MobileUI.setText(inputSearchProduct, "Bin Product");
        MobileUI.waitForElementVisible(iconEdit);
        LogUtils.info("Update added product");
        MobileUI.clickElement(iconEdit);
        MobileUI.setText(inputName, "Bin Product Updated");
        MobileUI.setText(inputPrice, "5695");
        MobileUI.waitForElementVisible(buttonSave);
        MobileUI.clickElement(buttonSave);
    }

    public void verifyUpdatedProduct() {
        LogUtils.info("Search and verify updated Product");
        MobileUI.verifyElementContentDesc(getProductNameByText("Bin Product Updated"), "Bin Product Updated", "Product updated name incorrect");
        MobileUI.verifyElementContentDesc(getProductPriceByText("Price: 5695"), "Price: 5695", "Product price incorrect");
    }

    public void deleteProduct() {
        MobileUI.waitForElementVisible(inputSearchProduct);
        MobileUI.setText(inputSearchProduct, "Bin Product Updated");
        MobileUI.waitForElementVisible(iconEdit);
        LogUtils.info("Delete product");
        MobileUI.clickElement(iconEdit);
        MobileUI.waitForElementVisible(buttonDelete);
        MobileUI.clickElement(buttonDelete);
    }

    public void verifyDeletedProduct() {
        LogUtils.info("Search and verify deleted Product");
        MobileUI.verifyElementPresentAndDisplayed(imageNoResultFound, "Product still shown");
    }
}