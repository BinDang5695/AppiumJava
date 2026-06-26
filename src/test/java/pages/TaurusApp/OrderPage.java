package pages.TaurusApp;

import drivers.DriverManager;
import keywords.MobileUI;
import utils.DateUtils;
import utils.LogUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends BasePage {

    public OrderPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    @AndroidFindBy(accessibility = "Table 1")
    private WebElement table1;

    @AndroidFindBy(accessibility = "Add Order")
    private WebElement buttonAddOrder;

    @AndroidFindBy(xpath = "(//android.widget.Button)[2]")
    private WebElement buttonAddmore;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Pepsi')]")
    private WebElement pepsi;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Sting')]")
    private WebElement sting;

    @AndroidFindBy(accessibility = "Bill: 30.000₫")
    private WebElement bill30k;

    @AndroidFindBy(accessibility = "Bill: 50.000₫")
    private WebElement bill50k;

    @AndroidFindBy(accessibility = "Add")
    private WebElement buttonAdd;

    @AndroidFindBy(accessibility = "Pay")
    private WebElement buttonPay;

    @AndroidFindBy(accessibility = "Total: 50.000₫")
    private WebElement totalPayment;

    @AndroidFindBy(accessibility = "Back")
    private WebElement buttonBack;

    @AndroidFindBy(xpath = "//android.view.View[starts-with(@content-desc,'List order or')]")
    private List<WebElement> orderByDates;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'-')]")
    private List<WebElement> orderTimes;

    @AndroidFindBy(accessibility = "30.000₫")
    private WebElement bill30kInDate;

    @AndroidFindBy(accessibility = "50.000₫")
    private WebElement bill50kInDate;

    @AndroidFindBy(accessibility = "end")
    private WebElement billStatus;

    public void logTodayOrder() {

        String today = DateUtils.getTodayForMobileUI();
        LogUtils.info("Expect order date: " + today);

        for (WebElement order : orderByDates) {
            String content = MobileUI.getElementAttribute(order, "content-desc");
            LogUtils.info("Found order content: " + content);

            if (content.contains(today)) {
                LogUtils.info("✅ Today order found: " + content);
                return;
            }
        }

        LogUtils.warn("❌ No order found for today: " + today);
    }

    public void logOrderTimes() {

        LogUtils.info("Logging order times:");

        for (WebElement time : orderTimes) {
            String content = MobileUI.getElementAttribute(time, "content-desc").trim();

            if (content.matches("\\d{1,2}:\\d{2}\\s-\\s\\d{1,2}:\\d{2}")) {
                LogUtils.info("⏰ Order time: " + content);
            }
        }
    }

    public void addNewOrder() {
        MobileUI.waitForElementVisible(table1);
        MobileUI.clickElement(table1);
        LogUtils.info("Add new order");
        MobileUI.waitForElementVisible(buttonAddOrder);
        MobileUI.clickElement(buttonAddOrder);
        MobileUI.waitForElementVisible(buttonAddmore);
        MobileUI.clickElement(buttonAddmore);
        MobileUI.waitForElementVisible(pepsi);
        MobileUI.clickElement(pepsi);
        MobileUI.waitForElementVisible(buttonAdd);
        MobileUI.clickElement(buttonAdd);
        MobileUI.verifyElementContentDesc(bill30k, "Bill: 30.000₫", "Total Bill incorrect");
        MobileUI.waitForElementVisible(buttonPay);
        MobileUI.clickElement(buttonPay);
        MobileUI.waitForElementVisible(buttonPay);
        MobileUI.clickElement(buttonPay);
    }

    public void verifyPaymentSuccess() {
        logTodayOrder();
        MobileUI.verifyElementContentDesc(table1, "Table 1", "Table not found");
        MobileUI.verifyElementContentDesc(billStatus, "end", "Status not found");
        logOrderTimes();
        MobileUI.verifyElementContentDesc(bill30kInDate, "30.000₫", "Bill 30k in Date not found");
    }

    public void addNewAndUpdatedOrder() {
        MobileUI.waitForElementVisible(table1);
        MobileUI.clickElement(table1);
        LogUtils.info("Add new order");
        MobileUI.waitForElementVisible(buttonAddOrder);
        MobileUI.clickElement(buttonAddOrder);
        MobileUI.waitForElementVisible(buttonAddmore);
        MobileUI.clickElement(buttonAddmore);
        MobileUI.waitForElementVisible(pepsi);
        MobileUI.clickElement(pepsi);
        MobileUI.waitForElementVisible(buttonAdd);
        MobileUI.clickElement(buttonAdd);
        MobileUI.verifyElementContentDesc(bill30k, "Bill: 30.000₫", "Total Bill incorrect");
        MobileUI.waitForElementVisible(buttonAddOrder);
        MobileUI.clickElement(buttonAddOrder);
        MobileUI.waitForElementVisible(sting);
        MobileUI.clickElement(sting);
        MobileUI.waitForElementVisible(buttonAdd);
        MobileUI.clickElement(buttonAdd);
        MobileUI.verifyElementContentDesc(bill50k, "Bill: 50.000₫", "Total Bill after updated incorrect");
        MobileUI.waitForElementVisible(buttonPay);
        MobileUI.clickElement(buttonPay);
        MobileUI.waitForElementVisible(buttonPay);
        MobileUI.clickElement(buttonPay);
    }

    public void verifyPaymentSuccessAfterUpdated() {
        logTodayOrder();
        MobileUI.verifyElementContentDesc(table1, "Table 1", "Table not found");
        MobileUI.verifyElementContentDesc(billStatus, "end", "Status not found");
        logOrderTimes();
        MobileUI.verifyElementContentDesc(bill50kInDate, "50.000₫", "Bill 50k in Date not found");
    }












}