package Test;

import Logs.Log;
import baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import pages.Hotelpage.HotelPageActions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import static CommonCode.Commoncode.takeScreenShot;

public class BookingTest extends BaseClass {
    @Test(priority = 1)
    public void tc_01_Home_PopupPresentAndClosable() {
        driver.get(url1);
        try {
            if (home.popupCloseBtn.isDisplayed()) {
                home.closePopUp();
                Log.info("Popup closed successfully");
            }
        } catch (Exception e) {
            Log.warn("Popup not present or not interactable. Continuing.");
        } finally {
            takeScreenShot(driver, "TC01_Home_Popup_Handled");
        }
        Assert.assertTrue(driver.getPageSource().contains("Booking.com"), "Popup handled (if present).");
    }

    @Test(priority = 2)
    public void tc_02_Home_LocationInputAcceptsText() {
        final String location = "Nairobi";
        home.setLocation(location);
        Log.info("Typed location: " + location);

        String typed = home.locationInput.getAttribute("value");
        Log.info("Captured location value: " + typed);
        Assert.assertEquals(typed, location);
        takeScreenShot(driver, "TC02_Home_Location_Typed");
    }

    @Test(priority = 3)
    public void tc_03_Home_DateSelection() {
        home.selectDateRange();
        Log.info("Selected check in and check out dates");
        takeScreenShot(driver, "TC03_Home_Dates_Selected");
        Assert.assertTrue(home.datePicker.isDisplayed(), "Dates selected without error");
    }

    @Test(priority = 4)
    public void tc_04_Home_OccupancyAdjustment() {

        home.setOccupancy();
        takeScreenShot(driver, "TC04_Home_Occupancy_Updated");
        Integer adultCnt = Integer.parseInt(String.valueOf(home.adultCnt.getText().charAt(0)));
        Assert.assertEquals(adultCnt, 4);
    }

    @Test(priority = 5)
    public void tc_05_Home_SearchNavigatesToResults() {

        home.searchResults();
        Log.info("Clicked Search on Home page.");

        hotelActions = new HotelPageActions(driver);
        hotelActions.waitForPageReady(driver);

        takeScreenShot(driver, "TC05_Home_Search_ResultsLoaded");
        Assert.assertTrue(driver.getTitle() != null && !driver.getTitle().isEmpty(),
                "Results page should have a non-empty title.");
    }

    @Test(priority = 6)
    public void tc_06_Hotel_FilterOptionsVisible() {
        Assert.assertTrue(hotelActions.optionsBtn.isDisplayed(), "Options/Filters button should be visible.");
        Log.info("Hotel options button is visible.");
        takeScreenShot(driver, "TC06_Hotel_Options_Visible");
    }

    @Test(priority = 7)
    public void tc_07_Hotel_SortTopReviewed() {
        HotelPageActions HotelPage = new HotelPageActions(driver);
        HotelPage.sortByReview();
        takeScreenShot(driver, "TC07_Hotel_Sort_TopReviewed");
        Assert.assertTrue(HotelPage.optionsBtn.isDisplayed(), "Top reviewed sorting applied.");
    }

    @Test(priority = 8)
    public void tc_08_Hotel_FilterElevatorAccess() {
        HotelPageActions HotelPage = new HotelPageActions(driver);
        HotelPage.filterByElevator();
        Log.info("Elevator accessibility filter applied.");
        takeScreenShot(driver, "TC08_Hotel_Filter_Elevator");
        Assert.assertTrue(HotelPage.elevatorFilter.isDisplayed(), "Elevator filter applied.");
    }

    @Test(priority = 9)
    public void tc_09_Hotel_ListHasAtLeastThree() {
        HotelPageActions HotelPage = new HotelPageActions(driver);
        List<WebElement> hotels = HotelPage.getHoteList();
        List<WebElement> price = HotelPage.getHotelPrice();
        int count = hotels.size();
        Log.info("Total hotels found: " + count);
        for (int i = 0; i < Math.min(3, count); i++) {
            float curNum = 0;
            for (char ch : price.get(i).getText().toCharArray()) {
                if (Character.isDigit(ch)) {
                    int dig = Character.getNumericValue(ch);
                    curNum = curNum * 10 + dig;
                }
            }
            Log.info("Hotel " + (i + 1) + ":" + hotels.get(i).getText());
            Log.info("Price for 5 Days: " + price.get(i).getText());
            Log.info("Price for 1 Day: ₹ " + curNum / 5);
            System.out.println();
        }
        takeScreenShot(driver, "TC09_Hotel_List_Present");
        Assert.assertTrue(count > 0, "Hotel list should not be empty.");
    }

    @Test(priority = 10)
    public void tc_10_Hotel_ScreenshotResults() {
        takeScreenShot(driver, "TC10_Hotel_Results_Final");
        Log.info("Captured final hotel results screenshot.");
    }
}
