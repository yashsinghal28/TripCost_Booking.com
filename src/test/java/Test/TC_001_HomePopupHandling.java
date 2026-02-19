package Test;

import Logs.Log;
import baseclass.BaseClass;
import pages.Homepage.HomePageActions;
import org.testng.annotations.Test;

import static CommonCode.Commoncode.takeScreenShot;

public class TC_001_HomePopupHandling extends BaseClass {
    private HomePageActions home;

    @Test(groups = {"TC_001"})
    public void handleHomePopup() {
        if (home == null) home = new HomePageActions(driver);
        driver.get(url1);

            if (home.popupCloseBtn.isDisplayed()) {
                home.closePopUp();
                Log.info("Popup closed successfully");
            }

            Log.warn("Popup not present or not interactable. Continuing.");

            takeScreenShot(driver, "TC01_Home_Popup_Handled");
    }
}
