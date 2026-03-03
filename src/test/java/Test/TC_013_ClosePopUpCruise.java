package Test;

import CommonCode.Commoncode;
import Logs.Log;
import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CruisePageActions;
import utils.Utils;

import java.io.IOException;
public class TC_013_ClosePopUpCruise extends BaseClass {
    @Test
    public void tc_13_closePopUpCruise() throws IOException {
        cruise = new CruisePageActions(driver);
        driver.navigate().to(url2);
        Assert.assertEquals(driver.getTitle(), "Home Page | Booking.com Cruises");
        Log.info("Validation of Title-->Passed");
        cruise.ClosePopUp();
        Log.info("Pop up closed Successfully");

        String Destination = Utils.fetchPropertyValue("searchDestination").toString();
        Assert.assertTrue(cruise.searchValidation.isDisplayed(), "Search bar not displayed");
        Assert.assertTrue(cruise.searchValidation.isEnabled(), "Search bar not clickable");
        cruise.enterDestination(Destination);
        Log.info("Search working Successfully");
        Commoncode.takeScreenShot(driver,"TC-13CookiesClosed and Search working");
    }

}