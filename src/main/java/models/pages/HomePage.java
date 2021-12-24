package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.components.authentication.CredsFormComponent;
import org.openqa.selenium.By;

public class HomePage extends Page {
    private final AppiumDriver<MobileElement> appiumDriver;
    private static final By appPurposeLabelSel = MobileBy.xpath("//android.widget.ScrollView[@content-desc=\"Home-screen\"]/android.view.ViewGroup/android.widget.TextView[2]");
    private static final By supportLabelSel = MobileBy.id("00000000-0000-002b-7fff-ffff00000037");

    public HomePage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
    }
    public String appPurposeLabel(){
        return appiumDriver.findElement(appPurposeLabelSel).getText();
    }
    public String supportLabel(){
       return appiumDriver.findElement(supportLabelSel).getText();
    }

}
