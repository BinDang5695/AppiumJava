package com.anhtester.bai20_mutiple_platform.testcases;

import com.anhtester.bai20_mutiple_platform.pages.*;
import com.anhtester.constants.ConfigData;
import com.anhtester.drivers.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.*;


import java.net.URL;
import java.time.Duration;
import java.util.Objects;

public class BaseTest {

    private AppiumDriverLocalService service;
    private String HOST = "127.0.0.1";
    private String PORT = "4723";
    private int TIMEOUT_SERVICE = 60;
    protected BasePage basePage;

    /**
     * Chạy Appium server với host và port được chỉ định.
     *
     * @param host Địa chỉ host của Appium server
     * @param port Port của Appium server
     */
    @BeforeSuite(alwaysRun = true)
    @Parameters({"host", "port"})
    public void startAppiumServer(
            @Optional String host,
            @Optional String port
    ) {
        if (!ConfigData.APPIUM_DRIVER_LOCAL_SERVICE.equalsIgnoreCase("true")) {
            System.out.println("⚡ Using existing Appium Server");
            return;
        }

        HOST = (host == null || host.isEmpty()) ? HOST : host;
        PORT = (port == null || port.isEmpty()) ? PORT : port;

        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withIPAddress(HOST)
                .usingPort(Integer.parseInt(PORT))
                .withTimeout(Duration.ofSeconds(60));

        service = AppiumDriverLocalService.buildService(builder);
        service.start();

        System.out.println("✅ Appium Server started at " + HOST + ":" + PORT);
    }

    @AfterSuite(alwaysRun = true)
    public void stopAppiumServer() {
        if (service != null && service.isRunning()) {
            service.stop();
            System.out.println("🛑 Appium Server stopped");
        }
    }

    /* ======================= TEST LEVEL ======================= */

    @BeforeMethod(alwaysRun = true)
    @Parameters({
            "platformName", "platformVersion", "deviceName",
            "udid", "automationName",
            "appPackage", "appActivity",
            "noReset", "fullReset",
            "bundleId", "wdaLocalPort",
            "systemPort"
    })
    public void setUpDriver(
            String platformName,
            String platformVersion,
            String deviceName,
            @Optional String udid,
            @Optional String automationName,
            @Optional String appPackage,
            @Optional String appActivity,
            boolean noReset,
            boolean fullReset,
            @Optional String bundleId,
            @Optional String wdaLocalPort,
            @Optional String systemPort
    ) {

        AppiumDriver driver;

        try {
            if (platformName.equalsIgnoreCase("Android")) {

                UiAutomator2Options options = new UiAutomator2Options()
                        .setPlatformName(platformName)
                        .setPlatformVersion(platformVersion)
                        .setDeviceName(deviceName)
                        .setAutomationName(
                                Objects.requireNonNullElse(automationName, "UiAutomator2")
                        )
                        .setNoReset(noReset)
                        .setFullReset(fullReset);

                if (udid != null) options.setUdid(udid);
                if (appPackage != null) options.setAppPackage(appPackage);
                if (appActivity != null) options.setAppActivity(appActivity);
                if (systemPort != null) options.setSystemPort(Integer.parseInt(systemPort));

                driver = new AndroidDriver(
                        new URL("http://" + HOST + ":" + PORT),
                        options
                );

            } else if (platformName.equalsIgnoreCase("iOS")) {

                XCUITestOptions options = new XCUITestOptions()
                        .setPlatformName(platformName)
                        .setPlatformVersion(platformVersion)
                        .setDeviceName(deviceName)
                        .setAutomationName(
                                Objects.requireNonNullElse(automationName, "XCUITest")
                        )
                        .setNoReset(noReset)
                        .setFullReset(fullReset);

                if (bundleId != null) options.setBundleId(bundleId);
                if (wdaLocalPort != null)
                    options.setWdaLocalPort(Integer.parseInt(wdaLocalPort));

                driver = new IOSDriver(
                        new URL("http://" + HOST + ":" + PORT),
                        options
                );

            } else {
                throw new IllegalArgumentException("Unsupported platform: " + platformName);
            }

            DriverManager.setDriver(driver);
            basePage = new BasePage();
            System.out.println("🚀 Driver started for thread " + Thread.currentThread().getId());

        } catch (Exception e) {
            throw new RuntimeException("❌ Cannot create Appium Driver", e);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.quitDriver();
            System.out.println("♻ Driver quit");
        }
    }

    /**
     * Tải xuống dữ liệu từ server. Chỉ dành cho Taurus App.
     *
     * param dataNumber Số thứ tự của dữ liệu cần tải xuống
     */

    protected BasePage basePage() {
        return basePage;
    }

    protected LoginPage loginPage() {
        return basePage.loginPage();
    }

    protected ConfigPage configPage() {
        return basePage.configPage();
    }

    protected ProductPage productPage() {
        return basePage.productPage();
    }

    protected MenuPage menuPage() {
        return basePage.menuPage();
    }

    protected DatePage datePage() {
        return basePage.datePage();
    }

    protected OrderPage orderPage() {
        return basePage.orderPage();
    }

    protected ProfilePage profilePage() {
        return basePage.profilePage();
    }

}