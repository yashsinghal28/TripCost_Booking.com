package Test;

import CommonCode.PreconditionHelper;
import Logs.Log;
import baseclass.BaseClass;
import pages.HotelPageActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static CommonCode.Commoncode.takeScreenShot;

public class TC_08_ElevatorFilter extends BaseClass {
    @Test()
    public void tc_08_applyElevatorAccessibilityFilter() {
        PreconditionHelper pre = new PreconditionHelper(this);
        driver.get(url1);
        pre.ensureUpToStep(5);
        HotelPageActions HotelPage = new HotelPageActions(driver);
        HotelPage.filterByElevator();
        Log.info("Elevator accessibility filter applied.");
        takeScreenShot(driver, "TC08_Hotel_Filter_Elevator");
        Assert.assertTrue(HotelPage.elevatorFilter.isDisplayed(), "Elevator filter applied.");
    }
}
