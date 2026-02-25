package Test;

import CommonCode.Commoncode;
import Logs.Log;
import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CruisePageActions;

public class TC_012_SecondURLOpen extends BaseClass {
    @Test
    public void tc_12_testSecondUrl() {
        cruise = new CruisePageActions(driver);
        driver.navigate().to(url2);
        Commoncode.takeScreenShot(driver, "TC-12 Opened The Page");
        boolean logoDisplayed = cruise.img().isDisplayed();
        Log.info(driver.getTitle());
        Assert.assertTrue(logoDisplayed);
    }
}
