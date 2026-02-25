package Test;

import CommonCode.PreconditionHelper;
import baseclass.BaseClass;
import pages.HotelPageActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static CommonCode.Commoncode.takeScreenShot;

public class TC_07_SortByReview extends BaseClass {
    @Test()
    public void tc_07_sortHotelsByTopReviewed() {
        PreconditionHelper pre = new PreconditionHelper(this);
        driver.get(url1);
        pre.ensureUpToStep(5);
        HotelPageActions HotelPage = new HotelPageActions(driver);
        HotelPage.sortByReview();
        takeScreenShot(driver, "TC07_Hotel_Sort_TopReviewed");
        Assert.assertTrue(HotelPage.optionsBtn.isDisplayed(), "Top reviewed sorting applied.");
    }
}
