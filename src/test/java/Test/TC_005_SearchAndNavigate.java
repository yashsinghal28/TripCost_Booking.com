package Test;

import CommonCode.PreconditionHelper;
import Logs.Log;
import baseclass.BaseClass;
import pages.Hotelpage.HotelPageActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static CommonCode.Commoncode.takeScreenShot;

public class TC_005_SearchAndNavigate extends BaseClass {
    @Test()
    public void searchAndNavigateToResults() {
        PreconditionHelper pre = new PreconditionHelper(this);
        pre.ensureUpToStep(4);

        home.searchResults();
        Log.info("Clicked Search on Home page.");

        hotelActions = new HotelPageActions(driver);
        hotelActions.waitForPageReady(driver);

        takeScreenShot(driver, "TC05_Home_Search_ResultsLoaded");
        Assert.assertTrue(driver.getTitle() != null && !driver.getTitle().isEmpty(),
                "Results page should have a non-empty title.");
    }
}
