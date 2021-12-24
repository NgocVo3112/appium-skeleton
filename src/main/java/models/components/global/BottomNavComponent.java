package models.components.global;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class BottomNavComponent {

    private final AppiumDriver<MobileElement> appiumDriver;
    private static final By homeLabelSel = MobileBy.AccessibilityId("Home");
    private static final By webviewLabelSel = MobileBy.AccessibilityId("Webview");
    private static final By loginLabelSel = MobileBy.AccessibilityId("Login");
    private static final By formsLabelSel = MobileBy.AccessibilityId("Forms");
    private static final By swipeLabelSel = MobileBy.AccessibilityId("Swipe");
    private static final By dragLabelSel = MobileBy.AccessibilityId("Drag");

    public BottomNavComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public MobileElement homeLabelElem() {
        return appiumDriver.findElement(homeLabelSel);
    }

    public MobileElement webviewLabelElem() {
        return appiumDriver.findElement(webviewLabelSel);
    }

    public MobileElement loginLabelElem() {
        return appiumDriver.findElement(loginLabelSel);
    }

    public MobileElement formsLabelElem(){
        return appiumDriver.findElement(formsLabelSel);
    }

    public MobileElement swipeLabelElem(){
        return appiumDriver.findElement(swipeLabelSel);
    }

    // Main interaction method
    @Step("Click on login label")
    public void clickOnLoginLabel(){
        appiumDriver.findElement(loginLabelSel).click();
    }

    @Step("Click on home label")
    public void clickOnHomeLabel(){
        appiumDriver.findElement(homeLabelSel).click();
    }

    @Step("Click on form label")
    public void clickOnFormLabel(){
        appiumDriver.findElement(formsLabelSel).click();
    }
    @Step("Click on swipe label")
    public void clickOnSwipeLabel(){
        appiumDriver.findElement(swipeLabelSel).click();
    }

    @Step("Click on webview label")
    public void clickOnWebViewLabel(){
        appiumDriver.findElement(webviewLabelSel).click();
    }

}
