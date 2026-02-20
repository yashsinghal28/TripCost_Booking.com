package Test;

import CommonCode.PreconditionHelper;
import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import static CommonCode.Commoncode.takeScreenShot;

public class TC_004_OccupancyAdjustment extends BaseClass {
    @Test()
    public void adjustOccupancy() {
        PreconditionHelper pre = new PreconditionHelper(this);
        pre.ensureUpToStep(3);

        home.setOccupancy();
        takeScreenShot(driver, "TC04_Home_Occupancy_Updated");
        Integer adultCnt = Integer.parseInt(String.valueOf(home.adultCnt.getText().charAt(0)));
        Assert.assertEquals(adultCnt, 4);
    }
}
