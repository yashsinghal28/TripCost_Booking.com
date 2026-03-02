package Test;

import CommonCode.Commoncode;
import baseclass.BaseClass;
import org.testng.annotations.Test;
import pages.CruisePageActions;

import static CommonCode.Commoncode.takeScreenShot;

public class TC_020_PrintStateList extends BaseClass {

    @Test
    public void tc_20_shipDetailsPrint() {
        cruise = new CruisePageActions(driver);
        driver.get(url2);
        cruise.ClosePopUp();
        cruise.chooseCruise();
        cruise.triggerCruiseBtn();
        cruise.triggerOnBoardingBtn();
        cruise.printStatsList();

        Commoncode.scrollBy(driver,0,410);
        cm.waitForDocumentReady(driver, 5);

        Commoncode.scrollBy(driver,0,600);
        takeScreenShot(driver, "TC-20_Print_State_List");
    }
}
