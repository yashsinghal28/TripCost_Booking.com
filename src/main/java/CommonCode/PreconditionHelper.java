package CommonCode;

import Logs.Log;
import baseclass.BaseClass;
import pages.HotelPageActions;
import pages.HomePageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.NoSuchElementException;

public class PreconditionHelper {
    private final WebDriver driver;
    private final BaseClass base;
    private HomePageActions home;
    private HotelPageActions hotelActions;

    public PreconditionHelper(BaseClass base) {
        this.base = base;
        this.driver = base.driver;

        this.home = new HomePageActions(driver);
        this.hotelActions = new HotelPageActions(driver);

        // Sync them back to the base class so everything shares the same state
        this.base.home = this.home;
        this.base.hotelActions = this.hotelActions;
    }

    public void ensureUpToStep(int step) {
        if (step >= 1) ensureHomePopupClosed();
        if (step >= 2) ensureLocationSet("Nairobi");
        if (step >= 3) ensureDatesSelected();
        if (step >= 4) ensureOccupancy();
        if (step >= 5) ensureSearchPerformed();
    }

    public void ensureHomePopupClosed() {
        try {
            if (home.popupCloseBtn.isDisplayed()) {
                home.closePopUp();
                Log.info("Popup closed by precondition helper");
            }
        } catch (NoSuchElementException e) {
            Log.info("Popup not present or already closed");
        }
    }

    public void ensureLocationSet(String location) {
        String cur = home.locationInput.getAttribute("value");

        if (!location.equals(cur)) {
            home.setLocation(location);
            Log.info("Location set by precondition helper: " + location);
        }
    }

    public void ensureDatesSelected() {
        home.selectDateRange();
        Log.info("Dates selected by precondition helper");
    }

    public void ensureOccupancy() {
        String text = home.adultCnt.getText();

        if (!text.isEmpty() && Character.getNumericValue(text.charAt(0)) != 4) {
            home.setOccupancy();
            Log.info("Occupancy adjusted by precondition helper");
        }
    }

    public void ensureSearchPerformed() {

            if (!hotelActions.getHoteList().isEmpty()) {
                return;
            }


        home.searchResults();
        Log.info("Search performed by precondition helper");

        // Re-initialize to capture the fresh page state after search
        this.hotelActions = new HotelPageActions(driver);
        this.base.hotelActions = this.hotelActions;

        hotelActions.waitForPageReady(driver);

        try {
            if (hotelActions.optionsBtn.isDisplayed()) {
                Log.info("Hotel page ready");
            }
        } catch (NoSuchElementException e) {
            Log.info("Hotel page loaded, but options button not found.");
        }
    }
}