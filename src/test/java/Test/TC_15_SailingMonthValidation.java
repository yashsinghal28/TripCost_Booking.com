package Test;

import baseclass.BaseClass;
import CommonCode.Commoncode;
import org.testng.Assert;
import org.testng.annotations.Test;
import Logs.Log;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class TC_15_SailingMonthValidation extends BaseClass {
    @Test()
    public void tc_15_checkSailingMonth() {

        Commoncode cm = new Commoncode();
        cm.implicitWait(driver);
        cruise.closeCookies();
        Log.info("Validation of Cookies");
        cruise.chooseCruise();
        Assert.assertEquals(cruise.validCurise.getText(), "Royal Caribbean Cruises");
        Log.info("Validation of curise Line");
        String rawText = cruise.getCruiseSailingMonth.getText();
        String cleanedText = rawText == null ? "" : rawText.trim();
        cleanedText = cleanedText.replaceAll("^[\\p{Punct}\\p{IsPunctuation}\\u2022\\s]+", "").trim();
        cleanedText = cleanedText.replaceAll("\\s+", " ");
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM uuuu", Locale.ENGLISH);

            YearMonth sailingYM = YearMonth.parse(cleanedText, formatter);
            YearMonth currentYM = YearMonth.now();

            if (!sailingYM.isBefore(currentYM)) {
                Log.info("Checked the Sailing Month date and Validated: " + sailingYM);
            } else {
                Assert.fail("Sailing Month is Expired: " + sailingYM + " (current: " + currentYM + ")");
            }
        } catch (DateTimeParseException e) {
            Assert.fail("Unable to parse sailing month/year from text: " + rawText
                    + " | cleaned: " + cleanedText
                    + " | " + e.getMessage());
        }
    }

}
