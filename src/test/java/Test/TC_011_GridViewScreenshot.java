package Test;

import CommonCode.PreconditionHelper;
import Logs.Log;
import baseclass.BaseClass;
import pages.Hotelpage.HotelPageActions;
import org.testng.annotations.Test;
import static CommonCode.Commoncode.takeScreenShot;
import org.openqa.selenium.JavascriptExecutor;

public class TC_011_GridViewScreenshot extends BaseClass {
    @Test()
    public void clickGridAndScreenshot() {
        PreconditionHelper pre = new PreconditionHelper(this);
        pre.ensureUpToStep(5);

        HotelPageActions hp = this.hotelActions;
        if (hp == null) {
            hp = new HotelPageActions(driver);
            this.hotelActions = hp;
        }

            hp.gridViewBtn.click();
            Log.info("Clicked Grid view button");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 800);");
        takeScreenShot(driver, "TC11_Grid_Click");
    }
}
