package Test;

import CommonCode.PreconditionHelper;
import Logs.Log;
import baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelPageActions;

import java.util.List;

import static CommonCode.Commoncode.takeScreenShot;

public class TC_006_GetAllHotels extends BaseClass {
    @Test()
    public void validateFilterOptionsVisible() {
        PreconditionHelper pre = new PreconditionHelper(this);
        HotelPageActions HotelPage = new HotelPageActions(driver);
        driver.get(url1);
        pre.ensureUpToStep(5);
        Assert.assertTrue(hotelActions.optionsBtn.isDisplayed(), "Options/Filters button should be visible.");
        Log.info("Hotel options button is visible.");
        List<WebElement> hotels = HotelPage.getHoteList();
        for(WebElement s : hotels){
            Log.info(s.getText());
        }
        takeScreenShot(driver, "TC06_Hotel_Options_Visible");
    }
}
