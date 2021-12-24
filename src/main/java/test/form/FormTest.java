package test.form;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;
import test_data.DataObjectBuilder;
import test_data.form.FormData;
import test_flows.form.FormFlow;

public class FormTest extends BaseTest {
    @Description("Test what user input can be displayed")
    @Test(dataProvider = "formData")
    public void VerifyWhatUserInputedCanbeDisplayed(FormData formData){
        AppiumDriver<MobileElement> androidDriver = getDriver();
        FormFlow formFlow = new FormFlow(androidDriver);
        formFlow.navigateToForm()
                .inputField(formData)
                .verifyTyped(formData);
    }

    @Description("Test user can switch on/off and text displayed")
    @Test
    public void VerifySwitchOnOff(){
        AppiumDriver<MobileElement> androidDriver = getDriver();
        FormFlow formFlow = new FormFlow(androidDriver);
        formFlow.navigateToForm()
                .verifySwitchStatus();
    }



    @DataProvider
    public FormData[] formData() {
        String jsonLoc = "/src/main/resources/test-data/form/formData.json";
        return DataObjectBuilder.buildDataObject(jsonLoc, FormData[].class);
    }

}
