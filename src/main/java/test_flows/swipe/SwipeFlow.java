package test_flows.swipe;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import models.components.global.BottomNavComponent;
import models.pages.SwipePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SwipeFlow {
    private AppiumDriver<MobileElement> appiumDriver;
    private SwipePage swipePage;

    public SwipeFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public SwipeFlow initSwipePage() {
        swipePage = new SwipePage(appiumDriver);
        return this;
    }

    public SwipeFlow navigateToSwipeForm() {
        if (swipePage == null) {
            initSwipePage();
        }
        // Bottom Nav Comp
        BottomNavComponent bottomNavComponent = swipePage.bottomNavComp();
        bottomNavComponent.clickOnSwipeLabel();
        return this;
    }
    @Step("Swipe horizontally and texts are displayed correctly")
    public SwipeFlow swipeHorizontalAndCheckTextsDisplayed() throws InterruptedException {
        if (swipePage == null) {
            throw new RuntimeException("Please use method navigateToSwipeForm first");
        }
        swipePage.swipeHorizontally();
        return this;
    }

    @Step("Swipe vertically to see icon at the end")
    public SwipeFlow swipeVerticalAndCheckIconDisplayed() throws InterruptedException {
        if (swipePage == null) {
            throw new RuntimeException("Please use method navigateToSwipeForm first");
        }
        swipePage.swipeVertically();
        return this;
    }



}
