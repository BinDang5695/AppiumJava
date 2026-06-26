package common;

import listeners.TestListener;
import pages.SauceLabsApp.BasePage;
import drivers.DriverManager;
import helpers.SystemHelpers;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
@Listeners({
        TestListener.class,
})
public class BaseTestSauceLabs extends BasePage {

    private AppiumDriverLocalService service;
    private String HOST = "127.0.0.1";
    private String PORT = "4723";
    private int TIMEOUT_SERVICE = 60;

    @BeforeSuite
    public void runAppiumServer() {
        SystemHelpers.killProcessOnPort(PORT);

        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress(HOST);
        builder.usingPort(Integer.parseInt(PORT));
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "info");
        builder.withTimeout(Duration.ofSeconds(TIMEOUT_SERVICE));

        service = AppiumDriverLocalService.buildService(builder);
        service.start();

        if (service.isRunning()) {
            System.out.println("##### Appium server started on " + HOST + ":" + PORT);
        } else {
            System.out.println("Failed to start Appium server.");
        }

    }

    @BeforeMethod
    @Parameters({
            "platformName",
            "platformVersion",
            "deviceName",
            "automationName",
            "appPackage",
            "appActivity",
            "noReset",
            "fullReset",
            "host",
            "port",
            "systemPort"
    })
    public void setUpDriver(
                            String platformName,
                            String platformVersion,
                            String deviceName,
                            String automationName,
                            String appPackage,
                            String appActivity,
                            boolean noReset,
                            boolean fullReset,
                            String host,
                            String port,
                            String systemPort
    ) {
        AndroidDriver driver;
        UiAutomator2Options options = new UiAutomator2Options();

        System.out.println("***SERVER ADDRESS: " + HOST);
        System.out.println("***SERVER POST: " + PORT);

        options.setPlatformName(platformName);
        options.setPlatformVersion(platformVersion);
        options.setAutomationName(automationName);
        options.setDeviceName(deviceName);
        options.setAppPackage(appPackage);
        options.setAppActivity(appActivity);
        options.setNoReset(noReset);
        options.setFullReset(fullReset);

        try {
            driver = new AndroidDriver(new URL("http://" + HOST + ":" + PORT), options);
            DriverManager.setDriver(driver);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {

        if (DriverManager.getDriver() != null) {
            DriverManager.quitDriver();
            System.out.println("===== SESSION CLOSED =====");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void stopAppiumServer() {

        if (service != null && service.isRunning()) {
            service.stop();
            System.out.println("##### Appium server stopped.");
        }
    }
}