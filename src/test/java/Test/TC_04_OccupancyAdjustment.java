package Test;

import Logs.Log;
import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePageActions;
import utils.Utils;

import java.io.IOException;

import static CommonCode.Commoncode.takeScreenShot;

public class TC_04_OccupancyAdjustment extends BaseClass {
    @Test()
    public void tc_04_adjustOccupancy() throws IOException {
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
        home.setOccupancy();
        takeScreenShot(driver, "TC04_Home_Occupancy_Updated");
        Integer adultCnt = Integer.parseInt(String.valueOf(home.adultCnt.getText().charAt(0)));
        Assert.assertEquals(adultCnt, 4);
    }
}
