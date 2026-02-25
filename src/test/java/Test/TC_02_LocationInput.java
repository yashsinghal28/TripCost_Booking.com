package Test;

import Logs.Log;
import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePageActions;

import static CommonCode.Commoncode.takeScreenShot;

public class TC_02_LocationInput extends BaseClass {
    @Test()
    public void tc_02_validateLocationInput() {
        HomePageActions home = new HomePageActions(driver);
        driver.get(url1);
        home.closePopUp();
        String location = "Nairobi";
        home.setLocation(location);
        Log.info("Typed location: " + location);

        String typed = home.locationInput.getAttribute("value");
        Log.info("Captured location value: " + typed);
        Assert.assertEquals(typed, location);
        takeScreenShot(driver, "TC02_Home_Location_Typed");
    }
}
