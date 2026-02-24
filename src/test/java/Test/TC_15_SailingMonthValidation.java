package Test;

import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import Logs.Log;
import pages.CruisePageActions;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TC_15_SailingMonthValidation extends BaseClass {

    @Test
    public void tc_15_checkSailingMonth() {
        cruise = new CruisePageActions(driver);
        driver.get(url2);
        cruise.ClosePopUp();
        Log.info("Validation of Cookies");

        cruise.chooseCruise();
        Assert.assertEquals(cruise.validCurise.getText(), "Royal Caribbean Cruises");
        Log.info("Validation of Cruise Line");

        String rawText = cruise.getCruiseSailingMonth.getText();
        String cleanedText = rawText.replaceAll("[^a-zA-Z0-9 ]", "").trim().replaceAll(" +", " ");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH);
        YearMonth sailingYM = YearMonth.parse(cleanedText, formatter);

        Assert.assertFalse(sailingYM.isBefore(YearMonth.now()), "Sailing Month has expired: " + sailingYM);
        Log.info("Checked the Sailing Month date and Validated: " + sailingYM);
    }
}