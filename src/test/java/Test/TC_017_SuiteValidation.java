package Test;

import Logs.Log;
import baseclass.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
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
        cruise.triggerCruiseButton();
        cruise.clickStateRoom();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(cruise.onB));
        js.executeScript("arguments[0].scrollIntoView(true);", el);
        String stateRoom = el.getText();
        Assert.assertEquals(stateRoom, "Suite");

        Log.info("Test for Suit Element Passed");
        js.executeScript("window.scrollBy(0, -500);");

        takeScreenShot(driver, "TC-17 suit validation screenshot-2 captured ");

    }
}
