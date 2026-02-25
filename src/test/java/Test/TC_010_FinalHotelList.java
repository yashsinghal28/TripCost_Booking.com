package Test;

import CommonCode.PreconditionHelper;
import Logs.Log;
import baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HotelPageActions;

import java.util.List;

import static CommonCode.Commoncode.takeScreenShot;

public class TC_010_FinalHotelList extends BaseClass {
    @Test()
    public void tc_10_captureAndValidateFinalResults() {
        PreconditionHelper pre = new PreconditionHelper(this);
        driver.get(url1);
        pre.ensureUpToStep(9);

        HotelPageActions HotelPage = new HotelPageActions(driver);
        List<WebElement> hotels = HotelPage.getHoteList();
        List<WebElement> price = HotelPage.getHotelPrice();
        int hotelCount =  hotels.size();
        int priceCount =   price.size();
        int available = Math.min(hotelCount, priceCount);
        Log.info("Total hotels found: " + hotelCount + ", prices found: " + priceCount);


        HotelPage.hotelCheckBox.click();
        Actions a = new Actions(driver);
        a.doubleClick(HotelPage.selectNoOfBeds).perform();

        int toPrint = Math.min(10, available);
        for (int i = 0; i < toPrint; i++) {
            float curNum = 0;
            String priceText = price.get(i).getText();
            for (char ch : priceText.toCharArray()) {
                if (Character.isDigit(ch)) {
                    int dig = Character.getNumericValue(ch);
                    curNum = curNum * 10 + dig;
                }
            }
            Log.info("Hotel " + (i + 1) + ":" + hotels.get(i).getText());
            Log.info("Price for 5 Days: " + priceText);
            Log.info("Price for 1 Day: ₹ " + (curNum / 5));
            System.out.println();
        }

        takeScreenShot(driver, "TC10_Hotel_Results_Final");
        Log.info("Captured final hotel results screenshot.");
    }
}
