package pages;

import Logs.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CruisePageActions {
    public By onB = By.xpath("//div[@id='expandCollapse_stateroom_Content']/h3[1]");
    @FindBy(xpath = "//div[contains(@class,'rowbutton') and normalize-space(.)='Royal Caribbean']")
    public WebElement chooseCruiseLine;
    @FindBy(xpath = "//h2[@id='brochureName1']") //h2[starts-with(text(),'3 Night Ensenada')]
    public WebElement cruiseButton;
    @FindBy(xpath = "//h3[@id='tabHeaderDining']")
    public WebElement headerDining;
    @FindBy(xpath = "//div[@id='expandCollapse_foodanddining_Content']/div/div[1]/div")
    public List<WebElement> exp;
    @FindBy(xpath = "//span[@property='item']/span")
    public WebElement validCurise;
    @FindBy(xpath = "//span[@id='defaultBreadcrumbs']")
    public WebElement checkName;
    @FindBy(xpath = "//div[@id='sailingDateList1']/ul/li[2]")
    public WebElement getCruiseSailingMonth;
    @FindBy(xpath = "(//p[@class='ui-block-a'])[22]")
    public WebElement numberOfElevators;
    @FindBy(xpath = "//button[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']")
    public WebElement closeButton;
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
    public CruisePageActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void closeCookies() {
        closeButton.click();
    }

    public void chooseCruise() {
        chooseCruiseLine.click();
    }

    public void triggerCruiseButton() {
        cruiseButton.click();
    }

    public void clickStateRoom() {
        stateRoom.click();
    }

    public void triggerOnBoardingButton() {
        onBoarding.click();
    }

    public WebElement img() {
        return image;
    }

    public List<String> getResult() {
        List<String> results = new ArrayList<>();
        results.add(headerDining.getAttribute("innerText"));

        for (int i = 1; i <= 10; i++) {
            String text = exp.get(i).getAttribute("innerText").trim();
            results.add(text);
        }

        results.add(stats.getAttribute("innerText"));
        return results;
    }

    public List<String> getSuitList() {
        List<String> suitList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            String text = suitItems.get(i).getAttribute("innerText").trim()
                    + " -> " + deck.get(i).getAttribute("innerText").trim();
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

