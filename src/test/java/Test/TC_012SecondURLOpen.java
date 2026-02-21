package Test;

import CommonCode.Commoncode;
import Logs.Log;
import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CruisePageActions;

import static baseclass.BaseClass.driver;

public class TC_012SecondURLOpen extends BaseClass {
    @Test
    public void tc_11_testSecondUrl() {
        Commoncode cm = new Commoncode();
        cruise = new CruisePageActions(driver);
        driver.navigate().to(url2);
        Commoncode.takeScreenShot(driver, "TC-11 Opened The Page");
        boolean logoDisplayed = cruise.img().isDisplayed();
        Log.info(driver.getTitle());
        Assert.assertTrue(logoDisplayed);
    }
}
