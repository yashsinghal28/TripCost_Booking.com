package Test;

import Logs.Log;
import baseclass.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CruisePageActions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import static CommonCode.Commoncode.takeScreenShot;

public class CuriseTest extends BaseClass {
    @Test(priority = 11)
    public void tc_11_testSecondUrl() {
        cruise = new CruisePageActions(driver);
        driver.get(url2);
        cm.waitForDocumentReady(driver, 10);
        takeScreenShot(driver, "TC-11 Opened The Page");
        boolean logoDisplayed = cruise.img().isDisplayed();
        Log.info(driver.getTitle());
        Assert.assertTrue(logoDisplayed);
    }

    @Test(priority = 12)
    public void tc_12_validateTitle() {
        Assert.assertEquals(driver.getTitle(), "Home Page | Booking.com Cruises");
        Log.info("Validation of Title-->Passed");
    }

    @Test(priority = 13)
    public void tc_13_validateCruiseLine() {
        cm.implicitWait(driver);
        cm.waitForDocumentReady(driver, 5);
        takeScreenShot(driver, "TC-12 Cookie -visible");
        cruise.closeCookies();
        cm.waitForDocumentReady(driver, 5);
        takeScreenShot(driver, "TC-13 Cookie Handled");
        Log.info("Validation of Cookies");
        cruise.chooseCruise();
        Assert.assertEquals(cruise.validCurise.getText(), "Royal Caribbean Cruises");
        Log.info("Validation of curise Line");
        cm.waitForDocumentReady(driver, 5);
        takeScreenShot(driver, "TC-14 SuccessFull selected CruiseLine");
        Log.info("Choosing Cruise Line --> Passed");

    }

    @Test(priority = 14)
    public void tc_14_checkSailingMonth() {
        String rawText = cruise.getCruiseSailingMonth.getText();
        String cleanedText = rawText == null ? "" : rawText.trim();
        StringBuilder sb = new StringBuilder();
        boolean nonLeadingFound = false;

        for (char c : cleanedText.toCharArray()) {
            if (!nonLeadingFound) {
                if (Character.isWhitespace(c) || Character.getType(c) == Character.OTHER_PUNCTUATION ||
                        Character.getType(c) == Character.DASH_PUNCTUATION ||
                        c == '•' || c == '-' || c == ':' ) {
                    continue;
                }
                nonLeadingFound = true;
            }
            sb.append(c);
        }
        cleanedText = sb.toString().trim();
        cleanedText = cleanedText.replace("  ", " ").trim();
        while (cleanedText.contains("  ")) {
            cleanedText = cleanedText.replace("  ", " ");
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH);
            YearMonth sailingYM = YearMonth.parse(cleanedText, formatter);
            YearMonth currentYM = YearMonth.now();

            if (sailingYM.isAfter(currentYM)) {
                Log.info("Checked the Sailing Month date and Validated: " + sailingYM);
            } else {
                Assert.fail("Sailing Month is Expired: " + sailingYM + " (current: " + currentYM + ")");
            }

        } catch (DateTimeParseException e) {
            Assert.fail("Unable to parse sailing month/year: '" + cleanedText + "' -> " + e.getMessage());
        }
    }

    @Test(priority = 15)
    public void tc_15_testCruisePage() {
        Assert.assertTrue(cruise.cruiseButton.isDisplayed());
        Log.info("Selected Cruise is Present and Verified Sailing Date");
        cruise.triggerCruiseButton();
        String name = cruise.checkName.getText();
        Assert.assertTrue(name.contains("Night"), "NOT SUCCESS");
        cm.waitForDocumentReady(driver, 5);
        Log.info("Validated and Selected Correct Curise");
        takeScreenShot(driver, "TC-15 cruise Selected");
    }

    @Test(priority = 16)
    public void tc_16_validationOfSuits() {
        cruise.clickStateRoom();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(cruise.onB));
        js.executeScript("arguments[0].scrollIntoView(true);", el);
        String stateRoom = el.getText();
        Assert.assertEquals(stateRoom, "Suite");
        Log.info("Test for Suit Element Passed");
        js.executeScript("window.scrollBy(0, -500);");
    }

    @Test(priority = 17)
    public void tc_17_printListOfRooms() {
        cruise.printSuitList();
        String source = driver.getPageSource();
        Assert.assertNotNull(source, "Page source is null!");
        cm.waitForDocumentReady(driver, 5);
        takeScreenShot(driver, "TC-16 cruise Stats");
        Log.info("SuccessFull Print of Stats Of Cruise");
    }

    @Test(priority = 18)
    public void tc_18_validateOnboarding() {
        Assert.assertFalse(driver.getPageSource().isEmpty(), "Page Source is unexpectedly empty!");
        Assert.assertTrue(cruise.headerDining.isEnabled(), "Dining header is not visible!");
        Log.info("Presence of Header is Verified");
        int elevatorCount = cruise.elevatorCount();
        Assert.assertTrue(elevatorCount > 0, "Elevator count is invalid or zero!");
        Log.info("Presence of Elevators is valid: " + elevatorCount);
    }

    @Test(priority = 19)
    public void tc_19_printStateList() {
        cruise.printStatsList();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 400);");
        cm.waitForDocumentReady(driver, 5);
        js.executeScript("window.scrollBy(0,-600)");
        takeScreenShot(driver, "TC-17_Curise_Details");

    }

    @Test(priority = 20)
    public void tc_20_validatePriceOrCurrencyToken() {
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
        takeScreenShot(driver, "TC-19_Stats");
        Assert.assertTrue(hasCurrency, "TC-20 FAILED: No currency/price related token found in page source!");
        js.executeScript("window.scrollBy(0,200);");
        takeScreenShot(driver, "TC-20_Price");
        Log.info("TC-20 PASSED: Price/currency token detected.");
    }
}
