package Test;

import CommonCode.PreconditionHelper;
import Logs.Log;
import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import static CommonCode.Commoncode.takeScreenShot;

public class TC_002_LocationInput extends BaseClass {
    @Test()
    public void validateLocationInput() {
        PreconditionHelper pre = new PreconditionHelper(this);
        pre.ensureUpToStep(1);
        final String location = "Nairobi";
        home.setLocation(location);
        Log.info("Typed location: " + location);

        String typed = home.locationInput.getAttribute("value");
        Log.info("Captured location value: " + typed);
        Assert.assertEquals(typed, location);
        takeScreenShot(driver, "TC02_Home_Location_Typed");
    }
}
