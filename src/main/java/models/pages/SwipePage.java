package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import models.components.global.BottomNavComponent;
import models.components.swipe.SwipePageComponent;
import org.openqa.selenium.By;

import java.util.List;

public class SwipePage extends Page{
    private final AppiumDriver<MobileElement> appiumDriver;


    private SwipePageComponent swipePageComponent;

    public SwipePage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        swipePageComponent = new SwipePageComponent(appiumDriver);
    }

    @Step("Swipe to see texts displayed correctly")
    public SwipePage swipeHorizontally() throws InterruptedException {
        swipePageComponent.swipeHorizontalUntilTextsDisplayed();
        return this;
    }

    @Step("Swipe to see icon at the end")
    public SwipePage swipeVertically() throws InterruptedException {
        swipePageComponent.swipeVerticalUntilIconDisplayed();
        return this;
    }

    public BottomNavComponent bottomNavigation() {
        return new BottomNavComponent(appiumDriver);
    }

    public SwipePageComponent swipePageComponent() {
        return new SwipePageComponent(appiumDriver);
    }
}
