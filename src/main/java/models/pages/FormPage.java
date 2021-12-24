package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class FormPage extends Page{
    private final AppiumDriver<MobileElement> appiumDriver;
    private static final By inputFieldSel = MobileBy.AccessibilityId("text-input");
    private static final By typedFieldSel = MobileBy.AccessibilityId("input-text-result");
    private static final By switchSel = MobileBy.AccessibilityId("switch");;
    private static final By switchStatusSel = MobileBy.AccessibilityId("switch-text");;


    public FormPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
    }

    public FormPage inputField(String field){
        appiumDriver.findElement(inputFieldSel).sendKeys(field);
        return this;
    }

    public String typedText(){
        return appiumDriver.findElement(typedFieldSel).getText();
    }

    public FormPage clickOnSwitch(){
        appiumDriver.findElement(switchSel).click();
        return this;
    }
    public String switchStatus(){
        return appiumDriver.findElement(switchStatusSel).getText();
    }
}
