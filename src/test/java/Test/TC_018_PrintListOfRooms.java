package Test;
import CommonCode.Commoncode;
import Logs.Log;
import baseclass.BaseClass;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CruisePageActions;
import java.time.Duration;
import static CommonCode.Commoncode.takeScreenShot;

public class TC_018_PrintListOfRooms extends BaseClass {
    @Test
    public void tc_18_printListOfRooms() throws InterruptedException {
        cruise = new CruisePageActions(driver);
        driver.get(url2);
        cm.waitForDocumentReady(driver,10);
        cruise.ClosePopUp();
        cruise.chooseCruise();
        cruise.triggerCruiseButton();
        cruise.clickStateRoom();
        cruise.printSuitList();

        String source = driver.getPageSource();
        Assert.assertNotNull(source, "Page source is null!");

        cm.waitForDocumentReady(driver, 5);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Commoncode.scrollBy(driver,0,700);

        takeScreenShot(driver, "TC-18 stateroom screenshot-1 captured ");
        Commoncode.scrollBy(driver,0,810);

        takeScreenShot(driver, "TC-18 stateroom screenshot-2 captured ");
        Log.info("SuccessFull Print of Stats Of Cruise");
    }
}
