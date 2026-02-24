package Test;

import CommonCode.PreconditionHelper;
import Logs.Log;
import baseclass.BaseClass;
import pages.HotelPageActions;
import org.testng.annotations.Test;
import static CommonCode.Commoncode.takeScreenShot;
import org.openqa.selenium.JavascriptExecutor;

public class TC_011_GridView extends BaseClass {
    @Test()
    public void clickGridAndScreenshot() {
        PreconditionHelper pre = new PreconditionHelper(this);
        driver.get(url1);
        pre.ensureUpToStep(5);

        HotelPageActions hp = this.hotelActions;
            hp.gridViewBtn.click();
            Log.info("Clicked Grid view button");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 800);");
        takeScreenShot(driver, "TC11_Grid_Click");
    }
}
