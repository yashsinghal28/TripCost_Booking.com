package Test;

import Logs.Log;
import baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HomePageActions;
import pages.HotelPageActions;
import utils.Utils;

import java.io.IOException;
import java.util.List;

import static CommonCode.Commoncode.takeScreenShot;

public class TC_010_FinalHotelList extends BaseClass {
    @Test()
    public void tc_10_captureAndValidateFinalResults() throws IOException {
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
        List<WebElement> hotels = hotelActions.getHoteList();
        List<WebElement> price = hotelActions.getHotelPrice();
        int hotelCount =  hotels.size();
        int priceCount =   price.size();
        int available = Math.min(hotelCount, priceCount);
        Log.info("Total hotels found: " + hotelCount + ", prices found: " + priceCount);


        hotelActions.hotelCheckBox.click();
        Actions a = new Actions(driver);
        a.doubleClick(hotelActions.selectNoOfBeds).perform();

        int toPrint = Math.min(10, available);
        for (int i = 0; i < toPrint; i++) {
            String priceText = price.get(i).getText();

            float curNum = Float.parseFloat(priceText.replaceAll("[^0-9]", ""));

            Log.info("Hotel " + (i + 1) + ": " + hotels.get(i).getText());
            Log.info("Price for 5 Days: " + priceText);
            Log.info("Price for 1 Day: ₹ " + (curNum / 5));
        }

        takeScreenShot(driver, "TC10_Hotel_Results_Final");
        Log.info("Captured final hotel results screenshot.");
    }
}