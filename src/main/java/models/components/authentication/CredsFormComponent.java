package models.components.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CredsFormComponent {

    private final AppiumDriver<MobileElement> appiumDriver;
    private static final By usernameSel = MobileBy.AccessibilityId("input-email");
    private static final By passwordSel = MobileBy.AccessibilityId("input-password");
    private static final By warningEmailSel = MobileBy.xpath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[1]");
    private static final By warningPasswordSel = MobileBy.xpath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[2]");


    public CredsFormComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    @Step("Input username as {username}")
    public CredsFormComponent inputUsername(String username){
        appiumDriver.findElement(usernameSel).sendKeys(username);
        return this;
    }

    @Step("Input password as {password}")
    public CredsFormComponent inputPassword(String password){
        appiumDriver.findElement(passwordSel).sendKeys(password);
        return this;
    }
    public String warningEmailText(){
        return  appiumDriver.findElement(warningEmailSel).getText();
    }
    public String warningPasswordText(){
        return  appiumDriver.findElement(warningPasswordSel).getText();
    }
}
