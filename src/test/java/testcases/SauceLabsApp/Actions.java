package testcases.SauceLabsApp;

import common.BaseTestSauceLabs;
import org.testng.annotations.Test;

public class Actions extends BaseTestSauceLabs {

    @Test
    public void draw() {
        loginPage().login();
        basePage().clickButtonViewMenu();
        basePage().clickButtonDrawing();
        drawingPage().clickButtonAllow();
        drawingPage().drawLine();
    }

    @Test
    public void longPress() {
        loginPage().login();
        basePage().clickButtonViewMenu();
        basePage().clickButtonWebView();
        webViewPage().clickInputURL();
        webViewPage().longPress();
    }

    @Test
    public void scroll() {
        loginPage().login();
        basePage().clickButtonViewMenu();
        basePage().clickButtonWebView();
        webViewPage().inputURL();
        webViewPage().clickButtonGoToSite();
        webViewPage().inputSearch();
        webViewPage().clickOptionSonTung();
        webViewPage().scrollOnYTB();

    }

    @Test
    public void swipe() {
        loginPage().login();
        basePage().clickButtonViewMenu();
        basePage().clickButtonWebView();
        webViewPage().inputURL();
        webViewPage().clickButtonGoToSite();
        webViewPage().inputSearch();
        webViewPage().clickOptionSonTung();
        webViewPage().swipeOnYTB();
    }

    @Test
    public void tap() {
        loginPage().login();
        basePage().clickButtonViewMenu();
        basePage().clickButtonWebView();
        webViewPage().inputURL();
        webViewPage().clickButtonGoToSite();
        webViewPage().inputSearch();
        webViewPage().clickOptionSonTung();
        webViewPage().tapOnYTB();
    }

}
