package Test;

import CommonCode.Commoncode;
import Logs.Log;
import baseclass.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static CommonCode.Commoncode.takeScreenShot;


public class TC_17_SuiteValidation extends BaseClass {
    @Test
    public void TC_17_validationOfSuits() {
        Commoncode cm = new Commoncode();
        cm.implicitWait(driver);
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

        // screenshot should be added here
//        takeScreenShot(driver, "TC-17 suit validation screenshot-1 captured ");
//        js.executeScript("window.scrollBy(0, 800);");
        takeScreenShot(driver, "TC-17 suit validation screenshot-2 captured ");

    }
}
