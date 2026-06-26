package testcases.TaurusApp;

import org.testng.annotations.Test;

public class DateTest extends BaseTest {

    @Test
    public void testSwipeAndZoom() {
        loginPage().login("admin", "admin");
        loginPage().verifyLoginSuccess();

    }

}
