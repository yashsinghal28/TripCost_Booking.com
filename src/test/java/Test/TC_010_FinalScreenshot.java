package Test;

import CommonCode.PreconditionHelper;
import Logs.Log;
import baseclass.BaseClass;
import org.testng.annotations.Test;
import static CommonCode.Commoncode.takeScreenShot;

public class TC_010_FinalScreenshot extends BaseClass {
    @Test()
    public void captureAndValidateFinalResults() {
        PreconditionHelper pre = new PreconditionHelper(this);
        driver.get(url1);
        pre.ensureUpToStep(9);

        takeScreenShot(driver, "TC10_Hotel_Results_Final");
        Log.info("Captured final hotel results screenshot.");
    }
}
