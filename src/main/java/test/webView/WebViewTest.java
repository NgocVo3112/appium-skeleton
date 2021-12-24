package test.webView;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.webView.WebViewFlow;

public class WebViewTest extends BaseTest {
    @Description("Make sure the menu text and hyperlink displayed correctly")
    @Test
    public void VerifyMenuTextAndHyperlinkOnWebView(){
        AppiumDriver<MobileElement> androidDriver = getDriver();
        WebViewFlow webViewFlow = new WebViewFlow(androidDriver);
        webViewFlow.navigateToWebViewForm()
                .verifyMenuTextAndHyperlink();
    }
}
