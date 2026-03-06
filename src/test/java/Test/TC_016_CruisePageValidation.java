package Test;

import Logs.Log;
import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CruisePageActions;

import static CommonCode.Commoncode.takeScreenShot;

public class TC_016_CruisePageValidation extends BaseClass {

    @Test
    public void tc_16_testCruisePage() {
        cruise = new CruisePageActions(driver);
        driver.get(url2);
        cruise.ClosePopUp();
        cruise.chooseCruise();
        Assert.assertTrue(cruise.cruiseBtn.isDisplayed(), "Cruise button not visible");
        Log.info("Selected Cruise is Present and Verified Sailing Date");
        cruise.triggerCruiseBtn();
        String name = cruise.checkNameTxt.getText();
        Assert.assertEquals(name, "3 Night Ensenada", "NOT SUCCESS");
        Log.info("Validated and Selected Correct Cruise");
        takeScreenShot(driver, "TC-16 of the Selected Correct Cruise");
    }

}
