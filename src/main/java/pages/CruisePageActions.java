package pages;

import Logs.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;

public class CruisePageActions {
    @FindBy(xpath = "//button[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']")
    public WebElement closeButton;

    @FindBy(xpath = "//input[@id='autoComplete']")
    public WebElement searchValidation;

    @FindBy(xpath = "//div[contains(text(),  'Royal Caribbean')]")
    public WebElement chooseCruiseLine;

    @FindBy(xpath = "//span[@property='item']/span")
    public WebElement CheckValidCurise;

    @FindBy(xpath = "//h2[@id='brochureName1']")
    public WebElement cruiseLinkButton;

    @FindBy(xpath = "//span[@id='defaultBreadcrumbs']")
    public WebElement checkNameText;

    @FindBy(xpath = "//h3[@id='tabHeaderDining']")
    public WebElement headerDiningText;

    @FindBy(xpath = "//div[@id='sailingDateList1']/ul/li[2]")
    public WebElement getCruiseSailingMonthText;

    @FindBy(xpath = "//div[@id='expandCollapse_foodanddining_Content']/div/div[1]/div")
    public List<WebElement> exp;

    @FindBy(xpath = "//button[@id='expandCollapse_stateroom']")
    public WebElement stateRoom;

    @FindBy(xpath = "//button[@id='expandCollapse_onboardExperience']")
    public WebElement onBoarding;

    @FindBy(xpath = "//div[@id='expandCollapse_stateroom_Content']/div/div[1]")
    public List<WebElement> suitItems;

    @FindBy(xpath = "//div[@id='expandCollapse_stateroom_Content']/div/div[1]/div[1]")
    public List<WebElement> deck;

    @FindBy(xpath = "//div[@class='ui-block-a mPadBottom']")
    public WebElement stats;

    @FindBy(xpath = "//a[@id='hp_searchContinue']")
    public WebElement image;

    @FindBy(xpath = "(//p[@class='ui-block-a'])[22]")
    public WebElement numberOfElevators;

    @FindBy(xpath =  "(//p[@class='ui-block-a'])[10]")
    public WebElement numberOfCrew;

    @FindBy(xpath = "(//p[@class='ui-block-a'])[9]")
    public  WebElement numberOfCapacity;

    @FindBy(xpath = "(//a[@id ='swipe_1'])[1]")
    public WebElement photoButton;

    @FindBy(xpath = "//div[@id='expandCollapse_stateroom_Content']/h3[1]")
    public WebElement suiteText;

    public CruisePageActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void ClosePopUp() {
        closeButton.click();
    }
    public void enterDestination(String searchDestination) {
        searchValidation.clear();
        searchValidation.sendKeys(searchDestination);
    }
    public void chooseCruise() {
        chooseCruiseLine.click();
    }
    public void triggerCruiseButton() {
        cruiseLinkButton.click();
    }
    public void clickStateRoom() {
        stateRoom.click();
    }
    public void triggerOnBoardingButton() {
        onBoarding.click();
    }
    public  void photoClickButton() {
        photoButton.click();
    }
    public WebElement img() {
        return image;
    }

    public List<String> getResult() {
        List<String> results = new ArrayList<>();
        results.add(headerDiningText.getAttribute("innerText"));

        for (int i = 1; i <= 10; i++) {
            String text = exp.get(i).getAttribute("innerText");
            results.add(text);
        }

        results.add(stats.getAttribute("innerText"));
        return results;
    }

    public List<String> getSuitList() {
        List<String> suitList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            String text = suitItems.get(i).getAttribute("innerText")
                    + " -> " + deck.get(i).getAttribute("innerText");
            suitList.add(text);
        }
        return suitList;
    }

    public void printSuitList() {
        List<String> ll = getSuitList();
        triggerOnBoardingButton();
        System.out.println("\n");
        for (String x : ll) {
            Log.info(x);
        }
        System.out.println("\n");
    }

    public void printStatsList() {
        Log.info("<STATS>");
        List<String> c = getResult();
        for (String cc : c) {
            Log.info(cc);
        }
    }

    public int elevatorCount() {
        String[] elevatorText = numberOfElevators.getAttribute("innerText").split(":");
        int elevatorCount = 0;

        try {
            elevatorCount = Integer.parseInt(elevatorText[1].trim());
        } catch (NumberFormatException e) {
            Assert.fail("Elevator count is not a valid number: " + elevatorText[1].trim());
        }
        return elevatorCount;
    }
}

