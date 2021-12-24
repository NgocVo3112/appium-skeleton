package test_flows.webView;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.global.BottomNavComponent;
import models.pages.WebViewPage;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class WebViewFlow {
    private AppiumDriver<MobileElement> appiumDriver;
    private WebViewPage webViewPage;

    public WebViewFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public WebViewFlow initWebViewPage() {
        webViewPage = new WebViewPage(appiumDriver);
        return this;
    }

    public WebViewFlow navigateToWebViewForm() {
        if (webViewPage == null) {
            initWebViewPage();
        }
        // Bottom Nav Comp
        BottomNavComponent bottomNavComponent = webViewPage.bottomNavComp();
        bottomNavComponent.clickOnWebViewLabel();
        return this;
    }

    public WebViewFlow verifyMenuTextAndHyperlink() {
        appiumDriver.context("WEBVIEW_com.wdiodemoapp");
        webViewPage.navToggleBtnElem().click();

        List<MobileElement> menuItems = webViewPage.menuItems();
        List<MenuItem> actualMenuItemList = new ArrayList<>();
        for (MobileElement menuItem : menuItems) {
            String menuText = menuItem.getText();
            String menuHyperLink = menuItem.getAttribute("href");
            if (StringUtils.isEmpty(menuText))
                actualMenuItemList.add(new MenuItem("GitHub", menuHyperLink));
            else
                actualMenuItemList.add(new MenuItem(menuText, menuHyperLink));
        }
        actualMenuItemList.forEach(System.out::println);
        List<String> actualMenuTextList = new ArrayList<>();
        List<String> actualMenuHrefList = new ArrayList<>();
        for (MenuItem menuItem : actualMenuItemList) {
            actualMenuTextList.add(menuItem.getText());
            actualMenuHrefList.add(menuItem.getHyperLink());
        }
        List<MenuItem> expectedMenuItems = new ArrayList<>();
        expectedMenuItems.add(new MenuItem("Docs", "https://webdriver.io/docs/gettingstarted"));
        expectedMenuItems.add(new MenuItem("API", "https://webdriver.io/docs/api"));
        expectedMenuItems.add(new MenuItem("Blog", "https://webdriver.io/blog"));
        expectedMenuItems.add(new MenuItem("Contribute", "https://webdriver.io/docs/contribute"));
        expectedMenuItems.add(new MenuItem("Community", "https://webdriver.io/community/support"));
        expectedMenuItems.add(new MenuItem("v7", "https://webdriver.io/versions"));
        expectedMenuItems.add(new MenuItem("GitHub", "https://github.com/webdriverio/webdriverio"));

        List<String> expectedMenuTextList = new ArrayList<>();
        List<String> expectedMenuHrefList = new ArrayList<>();
        for (MenuItem menuItem : expectedMenuItems) {
            expectedMenuTextList.add(menuItem.getText());
            expectedMenuHrefList.add(menuItem.getHyperLink());
        }
        Assert.assertTrue(actualMenuTextList.containsAll(expectedMenuTextList), "[ERR] Menu items display incorrectly !!!");
        Assert.assertTrue(actualMenuHrefList.containsAll(expectedMenuHrefList), "[ERR] Menu items display incorrectly !!!");
        return this;
    }

    public static class MenuItem {
        private String text;
        private String hyperLink;

        public MenuItem(String text, String hyperLink) {
            this.text = text;
            this.hyperLink = hyperLink;
        }

        public String Text() {
            return text;
        }

        public String HyperLink() {
            return hyperLink;
        }

        public String getText() {
            return text;
        }

        public String getHyperLink() {
            return hyperLink;
        }

        @Override
        public String toString() {
            return "MenuItem{" +
                    "text='" + text + '\'' +
                    ", hyperLink='" + hyperLink + '\'' +
                    '}';
        }
    }

}
