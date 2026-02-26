package Test;

import Logs.Log;
import baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePageActions;
import pages.HotelPageActions;
import utils.Utils;

import java.io.IOException;
import java.util.List;

import static CommonCode.Commoncode.takeScreenShot;

public class TC_06_GetAllHotels extends BaseClass {
    @Test()
    public void tc_06_getAllHotels() throws IOException {
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

        Assert.assertTrue(hotelActions.optionsBtn.isDisplayed(), "Options/Filters button should be visible.");
        Log.info("Hotel options button is visible.");
        List<WebElement> hotels = hotelActions.getHoteList();
        for(WebElement s : hotels){
            Log.info(s.getText());
        }
        takeScreenShot(driver, "TC06_Hotel_Options_Visible");
    }
}
