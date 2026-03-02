package Test;
import Logs.Log;
import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CruisePageActions;

public class TC_019_ValidateOnboarding  extends BaseClass {

    @Test
    public void tc_19_validateOnboarding() {
        cruise = new CruisePageActions(driver);
        driver.get(url2);
        cruise.ClosePopUp();
        String source = driver.getPageSource();
        cruise.chooseCruise();
        cruise.triggerCruiseBtn();
        cruise.triggerOnBoardingBtn();

        Assert.assertNotNull(source, "Page source is null!");
        cm.waitForDocumentReady(driver, 5);

        Assert.assertFalse(driver.getPageSource().isEmpty(), "Page Source is unexpectedly empty!");
        Assert.assertTrue(cruise.headerDiningTxt.isEnabled(), "Dining header is not visible!");
        Log.info("Presence of Header is Verified");
        int elevatorCount = cruise.elevatorCount();

        cruise.numberOfCrew.click();
        Log.info(cruise.numberOfCrew.getText());
        Log.info(cruise.numberOfCapacity.getText());

        Assert.assertTrue(elevatorCount > 0, "Elevator count is invalid or zero!");
        Log.info("Presence of Elevators is valid: " + elevatorCount);
    }

}