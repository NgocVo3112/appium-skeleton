package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebViewPage extends Page {

    private final AppiumDriver<MobileElement> appiumDriver;
    private static final By navToggleBtnSel = MobileBy.cssSelector(".navbar__toggle");
    private static final By menuItemsSel = MobileBy.cssSelector(".menu__list-item a");

    public WebViewPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
    }
    public WebElement navToggleBtnElem (){
        return appiumDriver.findElement(navToggleBtnSel);
    }

    public List<MobileElement> menuItems(){
        return appiumDriver.findElements(menuItemsSel);
    }
}
