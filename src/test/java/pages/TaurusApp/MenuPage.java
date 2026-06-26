package pages.TaurusApp;

import drivers.DriverManager;
import keywords.MobileUI;
import utils.LogUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MenuPage extends BasePage {
    public MenuPage() {
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

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Table\")]")
    private List<WebElement> searchTable;

    public void searchTable(String tableName) {
        clickMenuMenu();
        MobileUI.waitForElementVisible(inputSearch);
        MobileUI.setText(inputSearch, tableName);
    }

    public void checkTableResultTotal(int expectedTotal) {
        List<WebElement> listTables = listItemTable;
        LogUtils.info("Table total: " + listTables.size());
        //Assert.assertTrue(listTables.size() >= expectedTotal);
        MobileUI.assertTrueCondition(listTables.size() >= expectedTotal, "The table total is not correct.");
    }

    public void clickFirstItemTable() {
        MobileUI.clickElement(firstItemTable);
    }


}