package Test;

import CommonCode.Commoncode;
import baseclass.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static CommonCode.Commoncode.takeScreenShot;

@Test
public class TC_020_PrintStateList extends BaseClass {
    public void tc_20_shipDetailsPrint() throws InterruptedException {
        Commoncode cm = new Commoncode();
        cm.implicitWait(driver);
        cruise.ClosePopUp();
        cruise.chooseCruise();
        cruise.triggerCruiseButton();
        cruise.triggerOnBoardingButton();
        cruise.printStatsList();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 400);");
        cm.waitForDocumentReady(driver, 5);
        js.executeScript("window.scrollBy(0,-600)");
        takeScreenShot(driver, "TC-20_Print_State_List");
//        Thread.sleep(10000);
    }
}
