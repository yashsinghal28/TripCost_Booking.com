package Test;

import CommonCode.Commoncode;
import Logs.Log;
import baseclass.BaseClass;
import org.testng.annotations.Test;
import pages.CruisePageActions;
import static CommonCode.Commoncode.takeScreenShot;

public class TC_022_PhotoGallery extends BaseClass {
    @Test
    public void tc_22_PhotoGallary() throws InterruptedException {
        cruise = new CruisePageActions(driver);
        driver.get(url2);
        cruise.ClosePopUp();
        cruise.chooseCruise();
        cruise.triggerCruiseBtn();
        Commoncode.scrollBy(driver,0,200);
        cruise.photoClickBtn();

        takeScreenShot(driver, "TC-22 EnlargePhotoScreenshot");

        cm.waitForDocumentReady(driver, 5);
        takeScreenShot(driver, "TC-22 photoGalleryScreenshot");
        Log.info("Gallery viewed Successfully");
    }
}

