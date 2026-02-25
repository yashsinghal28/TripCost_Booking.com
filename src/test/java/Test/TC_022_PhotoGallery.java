package Test;

import Logs.Log;
import baseclass.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.CruisePageActions;
import static CommonCode.Commoncode.takeScreenShot;

public class TC_022_PhotoGallery extends BaseClass {
    @Test
    public void tc_22PhotoGallary() throws InterruptedException {
        cruise = new CruisePageActions(driver);
        driver.get(url2);
        cruise.ClosePopUp();
        cruise.chooseCruise();
        cruise.triggerCruiseButton();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 200);");
        cruise.photoClickButton();
        takeScreenShot(driver, "TC-22 EnlargePhotoScreenshot");

        cm.waitForDocumentReady(driver, 5);
        takeScreenShot(driver, "TC-22 photoGalleryScreenshot");
        Log.info("Gallery viewed Successfully");

    }
}

