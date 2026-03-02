package Test;

import Logs.Log;
import baseclass.BaseClass;
import pages.HomePageActions;
import pages.HotelPageActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static CommonCode.Commoncode.takeScreenShot;
import utils.Utils;

import java.io.IOException;

public class TC_011_GridView extends BaseClass {
    @Test()
    public void tc_11_clickGridView() throws IOException {
        home = new HomePageActions(driver);
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
        home.searchResults();
        Log.info("Clicked Search on Home page.");
        hotelActions = new HotelPageActions(driver);
        hotelActions.waitForPageReady(driver);
        hotelActions.gridViewBtn.click();
        Log.info("Clicked Grid view button");
        takeScreenShot(driver, "TC11_Grid_Click");
        Assert.assertTrue(hotelActions.gridViewBtn.isDisplayed(), "Grid View button is NOT displayed on the page");
        Log.info("Grid View button is displayed on the page");
    }
}