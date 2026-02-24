package Test;

import CommonCode.PreconditionHelper;
import Logs.Log;
import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import static CommonCode.Commoncode.takeScreenShot;

public class TC_006_FilterVisibility extends BaseClass {
    @Test()
    public void validateFilterOptionsVisible() {
        PreconditionHelper pre = new PreconditionHelper(this);
        pre.ensureUpToStep(5);

        Assert.assertTrue(hotelActions.optionsBtn.isDisplayed(), "Options/Filters button should be visible.");
        Log.info("Hotel options button is visible.");
        takeScreenShot(driver, "TC06_Hotel_Options_Visible");
    }
}
