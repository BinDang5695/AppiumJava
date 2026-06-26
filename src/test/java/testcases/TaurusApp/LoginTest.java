package testcases.TaurusApp;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginSuccess() {
        loginPage().login("admin", "admin");
        loginPage().verifyLoginSuccess();
    }

    @Test
    public void testLoginFailWithUsernameInvalid() {
        loginPage().login("admin123", "admin");
        loginPage().verifyLoginFailMessages(" Invalid email or password");
    }

    @Test
    public void testLoginFailWithPasswordInvalid() {
        loginPage().login("admin", "123456");
        loginPage().verifyLoginFailMessages(" Invalid email or password");
    }

    @Test
    public void testLoginFailWithBlankEmail() {
        loginPage().login("", "admin");
        loginPage().verifyLoginFailMessages("Email is required");
    }

    @Test
    public void testLoginFailWithBlankPassword() {
        loginPage().login("admin", "");
        loginPage().verifyLoginFailMessages("Password is required");
    }

    @Test
    public void testLoginFailWithBlankEmailAndPassword() {
        loginPage().login("", "");
        loginPage().verifyLoginFailMessages("Email is required", "Password is required");
    }

}