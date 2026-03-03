package Test;

import CommonCode.Commoncode;
import Logs.Log;
import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CruisePageActions;

public class TC_014_ValidateCruiseLine extends BaseClass{
    @Test
    public void tc_14_validateCruiseLine() {
        cruise = new CruisePageActions(driver);
        driver.get(url2);
        cm.implicitWait(driver);
        Commoncode.takeScreenShot(driver, "TC-14 Cookie -visible");
        cruise.ClosePopUp();
        Commoncode.takeScreenShot(driver, "TC-14 Cookie Handled");
        Log.info("Validation of Cookies");
        cruise.chooseCruise();
        Assert.assertEquals(cruise.checkValidCruise.getText(), "Royal Caribbean Cruises");
        Log.info("Validation of curise Line");
        Commoncode.takeScreenShot(driver, "TC-14 SuccessFull selected CruiseLine");
        Log.info("Choosing Cruise Line --> Passed");
    }
}
