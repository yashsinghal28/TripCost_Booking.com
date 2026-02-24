package Test;

import CommonCode.Commoncode;
import Logs.Log;
import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_014ValidateCruiseLine extends BaseClass{
    @Test()
    public void tc_14_validateCruiseLine() {

        Commoncode cm = new Commoncode();
        driver.get(url2);
        cm.implicitWait(driver);
        Commoncode.takeScreenShot(driver, "TC-14 Cookie -visible");
        cruise.ClosePopUp();
        Commoncode.takeScreenShot(driver, "TC-14 Cookie Handled");
        Log.info("Validation of Cookies");
        cruise.chooseCruise();
        Assert.assertEquals(cruise.validCurise.getText(), "Royal Caribbean Cruises");
        Log.info("Validation of curise Line");
        Commoncode.takeScreenShot(driver, "TC-13 SuccessFull selected CruiseLine");
        Log.info("Choosing Cruise Line --> Passed");

    }
}
