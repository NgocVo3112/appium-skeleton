package test_flows.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.global.BottomNavComponent;
import models.pages.LoginPage;
import org.testng.Assert;
import test_data.authentication.LoginCreds;

public class LoginFlow {

    private AppiumDriver<MobileElement> appiumDriver;
    private LoginPage loginPage;

    public LoginFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public LoginFlow initLoginPage() {
        loginPage = new LoginPage(appiumDriver);
        return this;
    }

    public LoginFlow navigateToLoginForm() {
        if (loginPage == null) {
            initLoginPage();
        }
        // Bottom Nav Comp
        BottomNavComponent bottomNavComponent = loginPage.bottomNavComp();
        bottomNavComponent.clickOnLoginLabel();
        return this;
    }

    public LoginFlow login(LoginCreds loginCreds) {
        if (loginPage == null)
            throw new RuntimeException("Please use method navigateToLoginForm first");

        // Fill login Form
        loginPage
                .inputUsername(loginCreds.getUsername())
                .inputPassword(loginCreds.getPassword())
                .clickOnLoginBtn();
        return this;
    }

    public void verifyLoginSuccess() {
        // Verification
        String actualLoginMsg = loginPage.loginDialogComp().msgTitle();
        boolean isTitleCorrect = actualLoginMsg.equals("Success");

        String customErrMsg = "[ERR] Login msg title incorrect!";
        Assert.assertTrue(isTitleCorrect, customErrMsg);
        loginPage.loginDialogComp().clickOK();
    }

    public void verifyLoginWithIncorrectCreds(LoginCreds loginCreds) {
        if (loginCreds.getUsername() == "") {
            String actualEmailWarning = loginPage.warningEmail();
            Assert.assertEquals(actualEmailWarning, "Please enter a valid email address",
                    "ERR: Warning email message displays incorrectly");
        }
        if (loginCreds.getPassword() == "") {
            String actualPasswordWarning = loginPage.warningPassword();
            Assert.assertEquals(actualPasswordWarning, "Please enter at least 8 characters",
                    "ERR: Warning password message displays incorrectly");
        }
        if (loginCreds.getPassword() == "" && loginCreds.getUsername() == "") {
            String actualEmailWarning = loginPage.warningEmail();
            String actualPasswordWarning = loginPage.warningPassword();
            Assert.assertEquals(actualEmailWarning, "Please enter a valid email address",
                    "ERR: Warning email message displays incorrectly");
            Assert.assertEquals(actualPasswordWarning, "Please enter at least 8 characters",
                    "ERR: Warning password message displays incorrectly");
        }


    }
}
