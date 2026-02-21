package Test;

import CommonCode.Commoncode;
import Logs.Log;
import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import static CommonCode.Commoncode.takeScreenShot;

public class TC_16_CruisePageValidation extends BaseClass {

    @Test
    public void tc_16_testCruisePage() {
        Commoncode cm = new Commoncode();
        cm.implicitWait(driver);
        cruise.closeCookies();
        cruise.chooseCruise();
        Assert.assertTrue(cruise.cruiseButton.isDisplayed(), "Cruise button not visible");
        Log.info("Selected Cruise is Present and Verified Sailing Date");
        cruise.triggerCruiseButton();
        String name = cruise.checkName.getText();
        Assert.assertEquals(name, "3 Night Bahamas Getaway", "NOT SUCCESS");
        Log.info("Validated and Selected Correct Cruise");
        takeScreenShot(driver, "TC-15 cruise Selected");
    }

}
