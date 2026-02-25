package Test;

import Logs.Log;
import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePageActions;

import static CommonCode.Commoncode.takeScreenShot;

public class TC_03_DateSelection extends BaseClass {
    @Test()
    public void tc_03_selectCheckInCheckOutDates() {
        HomePageActions home = new HomePageActions(driver);
        driver.get(url1);
        home.closePopUp();
        String location = "Nairobi";
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
