package Test;

import CommonCode.PreconditionHelper;
import Logs.Log;
import baseclass.BaseClass;
import pages.Hotelpage.HotelPageActions;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import static CommonCode.Commoncode.takeScreenShot;

public class TC_009_HotelListValidation extends BaseClass {
    @Test()
    public void validateHotelListAndPrices() {
        PreconditionHelper pre = new PreconditionHelper(this);
        pre.ensureUpToStep(8);

        HotelPageActions HotelPage = new HotelPageActions(driver);
        List<WebElement> hotels = HotelPage.getHoteList();
        List<WebElement> price = HotelPage.getHotelPrice();
        int hotelCount =  hotels.size();
        int priceCount =   price.size();
        int available = Math.min(hotelCount, priceCount);
        Log.info("Total hotels found: " + hotelCount + ", prices found: " + priceCount);
        int toPrint = Math.min(3, available);
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
        takeScreenShot(driver, "TC09_Hotel_List_Present");
        Assert.assertTrue(hotelCount > 0 && priceCount > 0, "Hotel list and prices should not be empty.");
    }
}
