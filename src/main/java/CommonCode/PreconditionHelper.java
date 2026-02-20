package CommonCode;

import Logs.Log;
import baseclass.BaseClass;
import pages.Hotelpage.HotelPageActions;
import pages.Homepage.HomePageActions;
import org.openqa.selenium.WebDriver;

public class PreconditionHelper {
    private final WebDriver driver;
    private final BaseClass base;
    private HomePageActions home;
    private HotelPageActions hotelActions;
    private final String url1;

    public PreconditionHelper(BaseClass base) {
        this.base = base;
        this.driver = base.driver;
        this.home = base.home;
        this.hotelActions = base.hotelActions;
        this.url1 = base.url1;
    }

    // Ensure steps 1..n are satisfied; methods are idempotent and safe to call repeatedly.
    public void ensureUpToStep(int step) {
        if (step >= 1) ensureHomePopupClosed();
        if (step >= 2) ensureLocationSet("Nairobi");
        if (step >= 3) ensureDatesSelected();
        if (step >= 4) ensureOccupancy();
        if (step >= 5) ensureSearchPerformed();
    }

    public void ensureHomePopupClosed() {
        if (driver == null) return;
        driver.get(url1);
        if (home == null) return;
        if (home.popupCloseBtn != null && home.popupCloseBtn.isDisplayed()) {
            home.closePopUp();
            Log.info("Popup closed by precondition helper");
        }
    }

    public void ensureLocationSet(String location) {
        if (home == null) return;
        String cur = home.locationInput.getAttribute("value");
        if (cur == null || !cur.equals(location)) {
            home.setLocation(location);
            Log.info("Location set by precondition helper: " + location);
        }
    }

    public void ensureDatesSelected() {
        if (home == null) return;
        home.selectDateRange();
        Log.info("Dates selected by precondition helper");
    }

    public void ensureOccupancy() {
        if (home == null) return;
        String text = home.adultCnt.getText();
        int cur = Character.getNumericValue(text.charAt(0));
        if (cur != 4) {
            home.setOccupancy();
            Log.info("Occupancy adjusted by precondition helper");
        }
    }

    public void ensureSearchPerformed() {
        if (base != null && base.hotelActions != null
                && base.hotelActions.getHoteList() != null
                && base.hotelActions.getHoteList().size() > 0) {
            this.hotelActions = base.hotelActions;
            return; // already searched and results present
        }

        if (home != null) {
            home.searchResults();
            Log.info("Search performed by precondition helper");
        }

        if (base != null) {
            base.hotelActions = new HotelPageActions(driver);
            this.hotelActions = base.hotelActions;
        } else {
            this.hotelActions = new HotelPageActions(driver);
        }

        this.hotelActions.waitForPageReady(driver);

        if (this.hotelActions.optionsBtn != null && this.hotelActions.optionsBtn.isDisplayed()) {
            Log.info("Hotel page ready");
        }
    }
}