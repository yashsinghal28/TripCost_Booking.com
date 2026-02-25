package Test;

import Logs.Log;
import baseclass.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CruisePageActions;

import static CommonCode.Commoncode.takeScreenShot;

public class TC_021_ValidatePriceOrCurrToken extends BaseClass {
    @Test
    public void tc_21_validatePriceOrCurrencyToken() throws InterruptedException {
        cruise = new CruisePageActions(driver);
        driver.get(url2);
        cruise.ClosePopUp();
        cruise.chooseCruise();
        cruise.triggerCruiseButton();
        cruise.triggerOnBoardingButton();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 400);");

        Log.info("TC-18: Validate price/currency token on cruise details page");
        cm.waitForDocumentReady(driver, 5);
        takeScreenShot(driver, "TC-18_OnboardingExperience");

        String source = driver.getPageSource();
        Assert.assertFalse(source.isEmpty(), "Page source is empty!");

        boolean hasCurrency = source.contains("$");
        js.executeScript("arguments[0].scrollIntoView()", cruise.stats);
        cm.waitForDocumentReady(driver, 5);
        takeScreenShot(driver, "TC-21_OnboardingDetails");

        Assert.assertTrue(hasCurrency, "TC-20 FAILED: No currency/price related token found in page source!");
        js.executeScript("window.scrollBy(0,200);");
        takeScreenShot(driver, "TC-20_Price");

        Log.info("TC-20 PASSED: Price/currency token detected.");
    }
}



