package test_flows.form;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.global.BottomNavComponent;
import models.pages.FormPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import test_data.form.FormData;

public class FormFlow {
    private AppiumDriver<MobileElement> appiumDriver;
    private FormPage formPage;

    public FormFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public FormFlow initFormPage(){
        formPage = new FormPage(appiumDriver);
        return this;
    }

    public FormFlow navigateToForm(){
        if(formPage == null)
            initFormPage();
        BottomNavComponent bottomNavComponent = formPage.bottomNavComp();
        bottomNavComponent.clickOnFormLabel();
        return this;
    }

    public FormFlow inputField(FormData formData){
        formPage.inputField(formData.getField());
        return this;
    }

    public void verifyTyped(FormData formData){
        Assert.assertEquals(formData.getField(),formPage.typedText(),"ERR- what user input are displayed incorrectly");
    }

    public FormFlow verifySwitchStatus(){
        formPage.clickOnSwitch();
        boolean switchStatus = formPage.switchStatus().equals("Click to turn the switch OFF");
        if(switchStatus){
            // Change to ON
            formPage.clickOnSwitch();
            Assert.assertTrue(formPage.switchStatus().equals("Click to turn the switch ON"));
        }
        else {
            formPage.clickOnSwitch();
            Assert.assertTrue(formPage.switchStatus().equals("Click to turn the switch OFF"));
        }
        return this;
    }
//    public void verifySwitchStatus(){
//        formPage.switchStatus();
//    }

}
