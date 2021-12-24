package test_flows.homePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.global.BottomNavComponent;
import models.pages.HomePage;
import org.testng.Assert;
import test_flows.authentication.LoginFlow;

public class HomeFlow {
    private AppiumDriver<MobileElement> appiumDriver;
    private HomePage homePage;

    public HomeFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public HomeFlow initHomePage() {
        homePage = new HomePage(appiumDriver);
        return this;
    }

    public HomeFlow navigateToHomeForm() {
        if (homePage == null) {
            initHomePage();
        }
        // Bottom Nav Comp
        BottomNavComponent bottomNavComponent = homePage.bottomNavComp();
        bottomNavComponent.clickOnHomeLabel();
        return this;
    }

    public HomeFlow verifyAppPurposeLabelDisplayed() {
        String actualAppPurposeStr = homePage.appPurposeLabel();
        Assert.assertEquals(actualAppPurposeStr, "Demo app for the appium-boilerplate", "ERR - App purpose is displayed incorrectly");
        return this;
    }

    public HomeFlow verifySupportLabelDisplayed() {
        String actualSupportStr = homePage.supportLabel();
        Assert.assertEquals(actualSupportStr, "Support", "ERR - Support is displayed incorrectly");
        return this;
    }

}
