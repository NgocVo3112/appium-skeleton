package test.swipe;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.swipe.SwipeFlow;

public class SwipeTest extends BaseTest {
    @Description("Swipe vertically to see the icon at the end")
    @Test
    public void VerifySwipeVerticallyToSeeIcon(){
        AppiumDriver<MobileElement> androidDriver = getDriver();
        SwipeFlow swipeFlow = new SwipeFlow(androidDriver);
        swipeFlow.navigateToSwipeForm()
                .SwipeVerticallyToSeeIcon();
    }

    @Description("User can swipe and texts are displayed correctly")
    @Test
    public void VerifySwipeHorizontalAndTextsAreDisplayed(){
        AppiumDriver<MobileElement> androidDriver = getDriver();
        SwipeFlow swipeFlow = new SwipeFlow(androidDriver);
        swipeFlow.navigateToSwipeForm()
                .swipeHorizontalAndTextsAreDisplayed();
    }
}
