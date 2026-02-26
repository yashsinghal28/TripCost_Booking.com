package Test;

import Logs.Log;
import baseclass.BaseClass;
import pages.HomePageActions;
import pages.HotelPageActions;
import org.testng.annotations.Test;
import static CommonCode.Commoncode.takeScreenShot;
import org.openqa.selenium.JavascriptExecutor;
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
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800);");
        takeScreenShot(driver, "TC11_Grid_Click");
    }
}
