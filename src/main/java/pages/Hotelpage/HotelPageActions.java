package pages.Hotelpage;

import Logs.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HotelPageActions {
    public WebDriver driver;
    public HotelPageActions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@data-testid='sorters-dropdown-trigger']")
    public WebElement optionsBtn;

    @FindBy(xpath = "//span[normalize-space(text())='Top reviewed']")
    public WebElement topReviewedBtn;

    @FindBy(xpath = "//div[@data-testid='filters-group-label-content' and contains(text(),'elevator')]")
    public WebElement elevatorFilter;

    @FindBy(xpath = "//a[@data-testid='title-link']//div[@data-testid = 'title']")
    public List<WebElement> hotelList;

    @FindBy(xpath = "//span[@data-testid = 'price-and-discounted-price']")
    public List<WebElement> priceList;
    @FindBy(xpath = "//label[text()='Grid']")
    public WebElement gridViewBtn;

    public void sortByReview() {
        optionsBtn.click();
        topReviewedBtn.click();
    }

    public void filterByElevator() {
        elevatorFilter.click();
    }

    // Kept the original method name; returns the hotel titles list
    public List<WebElement> getHoteList() {
        return hotelList;
    }

    public void waitForPageReady(WebDriver driver) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(15))
                    .until((ExpectedCondition<Boolean>) d ->
                            ((JavascriptExecutor) d)
                                    .executeScript("return document.readyState")
                                    .toString()
                                    .equals("complete")
                    );
        } catch (TimeoutException te) {
            Log.warn("Page readiness wait timed out; proceeding.");
        }
    }

    public List<WebElement> getHotelPrice(){
        return priceList;
    }
}
