package pages.TaurusApp;

import drivers.DriverManager;
import keywords.MobileUI;
import utils.LogUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BasePage {
    public ProfilePage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    @AndroidFindBy(accessibility = "Edit profile")
    private WebElement buttonEditProfile;

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Phone']")
    private WebElement inputPhone;

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Address']")
    private WebElement inputAddress;

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Old Password']")
    private WebElement inputOldPassword;

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='New Password']")
    private WebElement inputNewPassword;

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Confirm Password']")
    private WebElement inputConfirmPassword;

    @AndroidFindBy(accessibility = "Save")
    private WebElement buttonSave;

    @AndroidFindBy(accessibility = "Update & logout")
    private WebElement buttonUpdateAndLogout;

    @AndroidFindBy(accessibility = "Update profile success")
    private WebElement buttonUpdateProfileSuccess;

    @AndroidFindBy(accessibility = "User profile")
    private WebElement userProfile;

    @AndroidFindBy(accessibility = "Name: Admin")
    private WebElement verifyName;

    @AndroidFindBy(accessibility = "Email: admin@example.com")
    private WebElement verifyEmail;

    @AndroidFindBy(accessibility = "Phone: 0123456789")
    private WebElement verifyPhone;

    @AndroidFindBy(accessibility = "Address: 36 TQT")
    private WebElement verifyAddress;

    public void editProfile() {
        MobileUI.waitForElementVisible(buttonEditProfile);
        MobileUI.clickElement(buttonEditProfile);
        LogUtils.info("Edit Profile");
        MobileUI.setText(inputPhone, "0123456789");
        MobileUI.setText(inputAddress, "36 TQT");
        MobileUI.setText(inputOldPassword, "admin");
        MobileUI.setText(inputNewPassword, "adminbindz");
        MobileUI.setText(inputConfirmPassword, "adminbindz");
        MobileUI.hideKeyboard();
        MobileUI.waitForElementVisible(buttonSave);
        MobileUI.clickElement(buttonSave);
        MobileUI.waitForElementVisible(buttonUpdateAndLogout);
        MobileUI.clickElement(buttonUpdateAndLogout);
    }

    public void verifyEditedProfile() {
        MobileUI.waitForElementVisible(userProfile);
        LogUtils.info("Verify edited profile");
        MobileUI.verifyElementContentDesc(userProfile, "User profile", "User profile incorrect");
        MobileUI.verifyElementContentDesc(verifyName, "Name: Admin", "Name is incorrect");
        MobileUI.verifyElementContentDesc(verifyEmail, "Email: admin@example.com", "Email is incorrect");
        MobileUI.verifyElementContentDesc(verifyPhone, "Phone: 0123456789", "Phone is incorrect");
        MobileUI.verifyElementContentDesc(verifyAddress, "Address: 36 TQT", "Address is incorrect");
    }
}