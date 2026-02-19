package Test;

import CommonCode.PreconditionHelper;
import Logs.Log;
import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import static CommonCode.Commoncode.takeScreenShot;

public class TC_003_DateSelection extends BaseClass {
    @Test()
    public void selectCheckInCheckOutDates() {
        PreconditionHelper pre = new PreconditionHelper(this);
        pre.ensureUpToStep(2);
        home.selectDateRange();
        Log.info("Selected check in and check out dates");
        takeScreenShot(driver, "TC03_Home_Dates_Selected");
        Assert.assertTrue(home.datePicker.isDisplayed(), "Dates selected without error");
    }
}
