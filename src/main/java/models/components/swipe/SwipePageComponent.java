package models.components.swipe;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SwipeUtils;

public class SwipePageComponent {
    private final AppiumDriver<MobileElement> appiumDriver;
    private final SwipeUtils swipeUtils;
   // private static final By swipeTitleSel = MobileBy.xpath("//*[@text='Swipe horizontal']");
    private static final By compatibleTextSel = MobileBy.xpath("//*[@text='COMPATIBLE']");
    private static final By swipeItemsTextSel = MobileBy.xpath("(//android.view.ViewGroup[@content-desc=\"slideTextContainer\"])[*]/android.widget.TextView[1]");
    private static final By swipeItemsDescSel = MobileBy.xpath("(//android.view.ViewGroup[@content-desc=\"slideTextContainer\"])[*]/android.widget.TextView[2]");
    private static final By robotTextSel = MobileBy.xpath("//*[@text='You found me!!!']");
    private static final By robotIconSel = MobileBy.AccessibilityId("WebdriverIO logo");

    @AndroidFindBy(xpath = "//*[@text='Swipe horizontal']")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Or swipe vertical to find what I'm hiding.\"")
    private MobileElement swipeTitleSel;

    public SwipePageComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        swipeUtils = new SwipeUtils(appiumDriver);
    }

    @Step("Swipe and texts are displayed correctly")
    public SwipePageComponent swipeHorizontalUntilTextsDisplayed() {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 5L);
        wait.until(ExpectedConditions.visibilityOf(swipeTitleSel));
        swipeUtils.swipeUntilFoundElement("50", "10", "50", null, 5, compatibleTextSel);
        return this;
    }

    @Step("Swipe vertically to see icon displayed")
    public SwipePageComponent swipeVerticalUntilIconDisplayed() {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 5L);
        wait.until(ExpectedConditions.visibilityOf(swipeTitleSel));
        swipeUtils.swipeUntilFoundElement("30", null, "90", "40", 5, robotTextSel);
        return this;
    }
}
