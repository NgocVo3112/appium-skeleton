package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

public class SwipePage extends Page{
    private final AppiumDriver<MobileElement> appiumDriver;
    private static final By logoSel = MobileBy.AccessibilityId("WebdriverIO logo");
    private static final By swipeHorizontalTextSel = MobileBy.xpath("//*[@text='Swipe horizontal']");
    private static final By compatibleTextSel = MobileBy.xpath("//*[@text='Compatible']");

    public SwipePage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
    }
    public List<MobileElement> logo(){
        return appiumDriver.findElements(logoSel);
    }
    public MobileElement swipeHorizontalText(){
        return appiumDriver.findElement(swipeHorizontalTextSel);
    }
    public List<MobileElement> compatibleText(){
        return appiumDriver.findElements(compatibleTextSel);
    }
}
