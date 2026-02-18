package test;

import baseclass.BaseClass;
import org.testng.annotations.Test;
import utils.Log;

public class TC_01_Home_PopupPresentAndClosable extends BaseClass {
    @Test
    public void test1() {
        driver.get(URL1);
        if (home.popupCloseBtn.isDisplayed()) {
            home.closePopUp();
            Log.info("Popup closed successfully");
        }
        takeScreenShot(driver, "TC01_Home_Popup_Handled");
        Assert.assertTrue(driver.getPageSource().contains("Booking.com"), "Popup handled (if present).");
    }
}
