package Test;

import CommonCode.PreconditionHelper;
import baseclass.BaseClass;
import pages.HotelPageActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static CommonCode.Commoncode.takeScreenShot;

public class TC_007_SortByReview extends BaseClass {
    @Test()
    public void sortHotelsByTopReviewed() {
        PreconditionHelper pre = new PreconditionHelper(this);
        driver.get(url1);
        pre.ensureUpToStep(6);

        HotelPageActions HotelPage = new HotelPageActions(driver);
        HotelPage.sortByReview();
        takeScreenShot(driver, "TC07_Hotel_Sort_TopReviewed");
        Assert.assertTrue(HotelPage.optionsBtn.isDisplayed(), "Top reviewed sorting applied.");
    }
}
