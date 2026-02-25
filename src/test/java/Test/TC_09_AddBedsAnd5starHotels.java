package Test;

import CommonCode.PreconditionHelper;
import Logs.Log;
import baseclass.BaseClass;
import org.openqa.selenium.interactions.Actions;
import pages.HotelPageActions;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import static CommonCode.Commoncode.takeScreenShot;

public class TC_09_AddBedsAnd5starHotels extends BaseClass {
    @Test()
    public void tc_09_addBedsAnd5starHotels() {
        PreconditionHelper pre = new PreconditionHelper(this);
        driver.get(url1);
        pre.ensureUpToStep(8);

        HotelPageActions HotelPage = new HotelPageActions(driver);
        List<WebElement> hotels = HotelPage.getHoteList();
        List<WebElement> price = HotelPage.getHotelPrice();
        int hotelCount =  hotels.size();
        int priceCount =   price.size();
        Log.info("Total hotels found: " + hotelCount + ", prices found: " + priceCount);

        HotelPage.hotelCheckBox.click();
        Log.info("selected 5star hotels");
        Actions a = new Actions(driver);
        a.doubleClick(HotelPage.selectNoOfBeds).perform();

        Log.info("Added 2 bedroom");

        takeScreenShot(driver, "TC09_Hotel_List_Present");
        Assert.assertTrue(hotelCount > 0 && priceCount > 0, "Hotel list and prices should not be empty.");
    }
}
