package test.homePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.homePage.HomeFlow;

public class HomePageTest extends BaseTest {
    @Test
    public void verifyHomePage(){
        AppiumDriver<MobileElement> androidDriver = getDriver();
        HomeFlow homeFlow = new HomeFlow(androidDriver);
        homeFlow.navigateToHomeForm()
                .verifyAppPurposeLabelDisplayed();
               // .verifySupportLabelDisplayed();

    }
}
