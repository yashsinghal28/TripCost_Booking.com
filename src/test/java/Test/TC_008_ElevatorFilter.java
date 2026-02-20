package Test;

import CommonCode.PreconditionHelper;
import Logs.Log;
import baseclass.BaseClass;
import pages.HotelPageActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static CommonCode.Commoncode.takeScreenShot;

public class TC_008_ElevatorFilter extends BaseClass {
    @Test()
    public void applyElevatorAccessibilityFilter() {
        PreconditionHelper pre = new PreconditionHelper(this);
        pre.ensureUpToStep(7);

        HotelPageActions HotelPage = new HotelPageActions(driver);
        HotelPage.filterByElevator();
        Log.info("Elevator accessibility filter applied.");
        takeScreenShot(driver, "TC08_Hotel_Filter_Elevator");
        Assert.assertTrue(HotelPage.elevatorFilter.isDisplayed(), "Elevator filter applied.");
    }
}
