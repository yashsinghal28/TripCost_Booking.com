package Test;

import Logs.Log;
import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CurisePage.CruisePageActions;

import static baseclass.BaseClass.driver;

public class TC_012SecondURLOpen extends BaseClass {
    @Test(priority = 1)
    public void tc_11_testSecondUrl() {
        CruisePageActions cruise = new CruisePageActions(driver);
        cm.waitForDocumentReady(driver, 10);
        boolean logoDisplayed = cruise.chooseCruiseLine.isDisplayed();
        Log.info(driver.getTitle());
        Assert.assertTrue(logoDisplayed, "Cruise line element not displayed.");
    }
}
