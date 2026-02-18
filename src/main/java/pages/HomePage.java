package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Commoncode;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class HomePage extends Commoncode  {

    private final WebDriver driver;

    @FindBy(xpath = "//form[@aria-label='Search properties']//button[@data-testid='occupancy-config']")
    public WebElement adultCnt;

    @FindBy(xpath = "//button[@aria-label = 'Dismiss sign-in info.']")
    public WebElement popupCloseBtn;

    @FindBy(xpath = "//form[@aria-label='Search properties']//input[@name='ss']")
    public WebElement locationInput;

    @FindBy(xpath = "//form[@aria-label='Search properties']//button[@data-testid='searchbox-dates-container']")
    public WebElement datePicker;

    @FindBy(xpath = "//form[@aria-label='Search properties']//button[@data-testid='occupancy-config']")
    public WebElement occupancyBtn;

    @FindBy(xpath = "(//button[@type='button' and @tabindex='-1'])[2]")
    public WebElement adultsIncrementBtn;

    @FindBy(xpath = "//form[@aria-label='Search properties']//input[@name='ss']")
    public WebElement externalBtn;

    @FindBy(xpath = "//form[@aria-label='Search properties']//button[@type='submit' and .//span[normalize-space()='Search']]")
    public WebElement searchBtn;

    public HomePageActions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void closePopUp() {
        popupCloseBtn.click();
    }

    public void setLocation(String location) {
        locationInput.click();
        locationInput.clear();
        locationInput.sendKeys(location);
    }

    public void selectDateRange() {
        datePicker.click();

        ZoneId zone = ZoneId.systemDefault();
        LocalDate today = LocalDate.now(zone);
        LocalDate tomorrow = today.plusDays(1);
        LocalDate after5FromTomorrow = tomorrow.plusDays(5);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String tomorrowStr = tomorrow.format(fmt);
        String after5Str = after5FromTomorrow.format(fmt);

        String tomorrowXPath = String.format("//td[@role='gridcell']//span[@role='button' and @data-date='%s']", tomorrowStr);
        String after5XPath = String.format("//td[@role='gridcell']//span[@role='button' and @data-date='%s']", after5Str);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tomorrowXPath))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(after5XPath))).click();
    }

    public void setOccupancy() {
        occupancyBtn.click();
        adultsIncrementBtn.click();
        adultsIncrementBtn.click();
        externalBtn.click();
    }

    public void searchResults() {
        searchBtn.click();
    }
}