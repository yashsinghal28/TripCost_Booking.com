package Test;

import Logs.Log;
import baseclass.BaseClass;
import pages.HomePageActions;
import org.testng.annotations.Test;

import static CommonCode.Commoncode.takeScreenShot;

public class TC_01_BookingsHomePopupHandling extends BaseClass {
    private HomePageActions home;

    @Test()
    public void tc_01_handleHomePopup() {
        home = new HomePageActions(driver);
        driver.get(url1);

        if (home.popupCloseBtn.isDisplayed()) {
            home.closePopUp();
            Log.info("Popup closed successfully");
        }else{
            Log.warn("Popup not present or not interactable. Continuing.");
        }
        if( home.logoImage.isDisplayed()){
            Log.info("Logo Image Displayed");
        }
        else{
            Log.info("Logo Image not Displayed");
        }

        takeScreenShot(driver, "TC01_Home_Popup_Handled");
    }
}
