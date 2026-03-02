package Test;

import CommonCode.Commoncode;
import Logs.Log;
import baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CruisePageActions;
import java.time.Duration;

import static CommonCode.Commoncode.takeScreenShot;

public class TC_017_SuiteValidation extends BaseClass {
    @Test
    public void tc_17_validationOfSuits() {
        cruise = new CruisePageActions(driver);
        driver.get(url2);
        cruise.ClosePopUp();
        cruise.chooseCruise();
        cruise.triggerCruiseBtn();
        cruise.clickStateRoom();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(cruise.suiteTxt));
        Commoncode.scrollBy(driver,0,200);
        String stateRoomText = element.getText();
        Assert.assertEquals(stateRoomText, "Suite");

        Log.info("Test for Suit Element Passed");
        Commoncode.scrollBy(driver,0,-500);

        takeScreenShot(driver, "TC-17 suit validation screenshot-2 captured ");

    }
}
