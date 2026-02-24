package Test;

import Logs.Log;
import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CruisePageActions;

public class TC_013ValidateTitlePage extends BaseClass {
    @Test
    public void tc_13_validateTitle() {
        cruise = new CruisePageActions(driver);
        driver.navigate().to(url2);
        Assert.assertEquals(driver.getTitle(), "Home Page | Booking.com Cruises");
        Log.info("Validation of Title-->Passed");
    }
}