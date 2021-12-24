package test_flows.swipe;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
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

        WebDriverWait webDriverWait = new WebDriverWait(appiumDriver,30L);
        webDriverWait.until(ExpectedConditions.visibilityOf(swipePage.swipeHorizontalText()));
        return this;
    }

    public void SwipeVerticallyToSeeIcon (){
        // Get mobile window size
        Dimension windownSize = appiumDriver.manage().window().getSize();
        int screenHeight = windownSize.getHeight();
        int screenWidth = windownSize.getWidth();

        int xStartPoint = 50* screenWidth / 100;
        int xEndPoint = xStartPoint;
        int yStartPoint = 50 * screenHeight / 100;
        int yEndPoint = 10 * screenHeight / 100;

        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        TouchAction touchAction = new TouchAction(appiumDriver);
        int MAX_SWIPE_TIME = 5;
        int swipeTime = 0;

        while( swipeTime < MAX_SWIPE_TIME){
            List<MobileElement> matchedLogo = swipePage.logo();
            if (!matchedLogo.isEmpty()) break;
            touchAction
                    .press(startPoint)
                    .waitAction( new WaitOptions().withDuration(Duration.ofSeconds(1)))
                    .moveTo(endPoint)
                    .release()
                    .perform();
            swipeTime ++;
        }

    }

    public void swipeHorizontalAndTextsAreDisplayed(){
        // Get mobile window size
        Dimension windownSize = appiumDriver.manage().window().getSize();
        int screenHeight = windownSize.getHeight();
        int screenWidth = windownSize.getWidth();

        int xStartPoint = 50* screenWidth / 100;
        int xEndPoint = 10* screenWidth / 100;
        int yStartPoint = 50 * screenHeight / 100;
        int yEndPoint = yStartPoint;

        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        TouchAction touchAction = new TouchAction(appiumDriver);
        int MAX_SWIPE_TIME = 5;
        int swipeTime = 0;

        while( swipeTime < MAX_SWIPE_TIME){
            List<MobileElement> matchedCard = swipePage.compatibleText();
            if (!matchedCard.isEmpty()) break;
            touchAction
                    .press(startPoint)
                    .waitAction( new WaitOptions().withDuration(Duration.ofSeconds(1)))
                    .moveTo(endPoint)
                    .release()
                    .perform();
            swipeTime ++;
        }
    }


}
