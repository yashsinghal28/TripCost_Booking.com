package test;

import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.Commoncode;
import utils.Log;

public class TC_02_Home_LocationInputAcceptsText extends BaseClass {

    @Test(priority = 2)
    public void TC_02_Home_LocationInputAcceptsText() throws Exception {

        HomePage home = new HomePage(driver);
        if (home.popupCloseBtn.isDisplayed()) {
            home.closePopUp();
            Log.info("Popup closed successfully");
        }
        final String location = "Nairobi";
        home.setLocation(location);
        Log.info("Typed location: " + location);

        String typed = home.locationInput.getAttribute("value");
        Log.info("Captured location value: " + typed);
        Assert.assertEquals(typed, location);
        Commoncode.takeScreenshot(driver, "TC02_Home_Location_Typed");
    }

}
