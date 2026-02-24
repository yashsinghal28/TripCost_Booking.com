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
import static baseclass.BaseClass.driver;

public class TC_018_PrintListOfRooms extends BaseClass {
    @Test
    public void TC_18_printListOfRooms() throws InterruptedException {

        Commoncode cm = new Commoncode();
        cm.implicitWait(driver);
        cruise.ClosePopUp();
        cruise.chooseCruise();
        cruise.triggerCruiseButton();
        cruise.clickStateRoom();
        cruise.printSuitList();
        String source = driver.getPageSource();
        Assert.assertNotNull(source, "Page source is null!");
        cm.waitForDocumentReady(driver, 5);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(cruise.onB));
//
//        js.executeScript("arguments[0].scrollIntoView(true);", el);
         js.executeScript("window.scrollBy(0, 700);");
          Thread.sleep(3000);

        takeScreenShot(driver, "TC-18 stateroom screenshot-1 captured ");
        js.executeScript("window.scrollBy(0, 810);");
        Thread.sleep(3000);

        takeScreenShot(driver, "TC-18 stateroom screenshot-2 captured ");

//        driver.quit();
        Log.info("SuccessFull Print of Stats Of Cruise");
    }
}
