package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.time.Duration;

public abstract class BasePage {
    protected static WebDriver driver;
    private final int DEFAULT_TIMEOUT = 20 ;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void uploadFile(By locator, String filePath) {
        WebElement uploadElement = driver.findElement(locator);
        File file = new File(filePath);
        uploadElement.sendKeys(file.getAbsolutePath());
    }

    protected WebElement get(By locator) {
        return waitForElementVisible(locator);
    }

    protected void click(By locator) {
        get(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = get(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected boolean isDisplayed(By locator) {
        try {
            return get(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isEnabled(By locator) {
        try {
            return get(locator).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }


    protected WebElement waitForElementVisible(By locator) {
        return waitForElementVisible(locator, DEFAULT_TIMEOUT);
    }

    protected WebElement waitForElementVisible(By locator, int timeoutInSeconds) {
        waitForPageLoad();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT)).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete")
        );
    }
}
