package testcases.SauceLabsApp;

import common.BaseTestAndroidPlatform;
import org.testng.annotations.Test;

public class Notification extends BaseTestAndroidPlatform {

    @Test
    public void testHandleNotification() {
        basePage().handleNotification();
    }
}
