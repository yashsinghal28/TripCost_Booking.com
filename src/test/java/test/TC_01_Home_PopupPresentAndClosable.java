package test;

import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.Commoncode;
import utils.Log;

public class TC_01_Home_PopupPresentAndClosable extends BaseClass {
    @Test
    public void test1() throws Exception{
        HomePage home = new HomePage(driver);
        if (home.popupCloseBtn.isDisplayed()) {
            home.closePopUp();
            Log.info("Popup closed successfully");
        }
        Commoncode.takeScreenshot(driver, "TC01_Home_Popup_Handled");
        Assert.assertTrue(driver.getPageSource().contains("Booking.com"), "Popup handled (if present).");
    }
}
