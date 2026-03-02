package Test;

import Logs.Log;
import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePageActions;
import utils.Utils;

import java.io.IOException;

import static CommonCode.Commoncode.takeScreenShot;

public class TC_003_BookingDateSelection extends BaseClass {
    @Test()
    public void tc_03_selectCheckInCheckOutDates() throws IOException {
        HomePageActions home = new HomePageActions(driver);
        driver.get(url1);
        home.closePopUp();
        String location = Utils.fetchPropertyValue("location").toString();
        home.setLocation(location);
        Log.info("Typed location: " + location);
        String typed = home.locationInput.getAttribute("value");
        Log.info("Captured location value: " + typed);
        home.selectDateRange();
        Log.info("Selected check in and check out dates");
        takeScreenShot(driver, "TC03_Home_Dates_Selected");
        Assert.assertTrue(home.datePicker.isDisplayed(), "Dates selected without error");
    }
}
