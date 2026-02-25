package Test;

import Logs.Log;
import baseclass.BaseClass;
import org.openqa.selenium.interactions.Actions;
import pages.HomePageActions;
import pages.HotelPageActions;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import static CommonCode.Commoncode.takeScreenShot;

public class TC_09_AddBedsAnd5starHotels extends BaseClass {
    @Test()
    public void tc_09_addBedsAnd5starHotels() {
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
        List<WebElement> hotels = hotelActions.getHoteList();
        List<WebElement> price = hotelActions.getHotelPrice();
        int hotelCount =  hotels.size();
        int priceCount =   price.size();
        Log.info("Total hotels found: " + hotelCount + ", prices found: " + priceCount);

        hotelActions.hotelCheckBox.click();
        Log.info("selected 5star hotels");
        Actions a = new Actions(driver);
        a.doubleClick(hotelActions.selectNoOfBeds).perform();

        Log.info("Added 2 bedroom");

        takeScreenShot(driver, "TC09_Hotel_List_Present");
        Assert.assertTrue(hotelCount > 0 && priceCount > 0, "Hotel list and prices should not be empty.");
    }
}
