package Test;

import CommonCode.Commoncode;
import Logs.Log;
import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_019_ValidateOnboarding  extends BaseClass {

    public void TC_19_validateOnboarding() {
        Commoncode cm = new Commoncode();
        cm.implicitWait(driver);
        cruise.ClosePopUp();
        String source = driver.getPageSource();
        cruise.chooseCruise();
        cruise.triggerCruiseButton();
        cruise.triggerOnBoardingButton();

        Assert.assertNotNull(source, "Page source is null!");
        cm.waitForDocumentReady(driver, 5);

        Assert.assertFalse(driver.getPageSource().isEmpty(), "Page Source is unexpectedly empty!");
        Assert.assertTrue(cruise.headerDining.isEnabled(), "Dining header is not visible!");
        Log.info("Presence of Header is Verified");
        int elevatorCount = cruise.elevatorCount();
        Assert.assertTrue(elevatorCount > 0, "Elevator count is invalid or zero!");
        Log.info("Presence of Elevators is valid: " + elevatorCount);
    }

}
