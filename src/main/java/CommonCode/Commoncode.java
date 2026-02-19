package CommonCode;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class Commoncode {
    public void implicitWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void takeScreenShot(WebDriver driver, String name) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),
                    new File(System.getProperty("user.dir") + "/ScreenShot/" + name + ".jpeg"));
            System.out.println(name + ": Screenshot has been captured.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void waitForDocumentReady(WebDriver driver, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(d -> ((JavascriptExecutor) d)
                .executeScript("return document.readyState")
                .equals("complete"));
    }

}
