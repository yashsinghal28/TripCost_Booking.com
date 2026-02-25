package Test;

import Logs.Log;
import baseclass.BaseClass;
import pages.HomePageActions;
import pages.HotelPageActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static CommonCode.Commoncode.takeScreenShot;

public class TC_08_ElevatorFilter extends BaseClass {
    @Test()
    public void tc_08_applyElevatorAccessibilityFilter() {
        home = new HomePageActions(driver);
        driver.get(url1);
        home.closePopUp();
        String location = "Nairobi";
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
        hotelActions.filterByElevator();
        Log.info("Elevator accessibility filter applied.");
        takeScreenShot(driver, "TC08_Hotel_Filter_Elevator");
        Assert.assertTrue(hotelActions.elevatorFilter.isDisplayed(), "Elevator filter applied.");
    }
}
