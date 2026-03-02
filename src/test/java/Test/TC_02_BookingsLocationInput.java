package Test;

import Logs.Log;
import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePageActions;
import utils.Utils;

import java.io.IOException;

import static CommonCode.Commoncode.takeScreenShot;

public class TC_02_BookingsLocationInput extends BaseClass {
    @Test()
    public void tc_02_validateLocationInput() throws IOException {
        HomePageActions home = new HomePageActions(driver);
        driver.get(url1);
        home.closePopUp();
        home.currencyBtn.click();
        home.indianCurrencyText.click();
        String currency = home.currenyText.getText();
        Assert.assertEquals(currency,"INR");
        Log.info("Indian Currency Selected");
        String location = Utils.fetchPropertyValue("location").toString();
        home.setLocation(location);
        Log.info("Typed location: " + location);

        String typed = home.locationInput.getAttribute("value");
        Log.info("Captured location value: " + typed);
        Assert.assertEquals(typed, location);
        takeScreenShot(driver, "TC02_Home_Location_Typed");
    }
}
