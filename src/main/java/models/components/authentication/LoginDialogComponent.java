package models.components.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginDialogComponent {

    private final AppiumDriver<MobileElement> appiumDriver;
    // private final static By msgTitleSel = MobileBy.id("android:id/alertTitle");

    @AndroidFindBy(id = "android:id/alertTitle")
    @iOSXCUITFindBy(id = "Success")
    private MobileElement msgTitleSel;

    @AndroidFindBy(xpath = "//*[@text='OK']")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"OK\"")
    private MobileElement okBtnSel;

    public LoginDialogComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(5)), this);
    }

    public String msgTitle(){
        return msgTitleSel.getText();
    }

    public LoginDialogComponent clickOK(){
        okBtnSel.click();
        return this;
    }



}
