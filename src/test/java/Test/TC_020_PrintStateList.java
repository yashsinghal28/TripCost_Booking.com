package Test;

import CommonCode.Commoncode;
import baseclass.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.CruisePageActions;

import static CommonCode.Commoncode.takeScreenShot;

public class TC_020_PrintStateList extends BaseClass {

    @Test
    public void tc_20_shipDetailsPrint() throws InterruptedException {
        cruise = new CruisePageActions(driver);
        driver.get(url2);
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
    }
}
