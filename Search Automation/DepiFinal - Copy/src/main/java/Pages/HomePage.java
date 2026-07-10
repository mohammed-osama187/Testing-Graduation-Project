package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By SearchField = By.cssSelector("#search input[name='search']");
    By SearchBtn = By.cssSelector("#search button.type-submit");
    By CategoryDropdownToggle = By.cssSelector("#search button.dropdown-toggle");

    public void EnterSearchTerm(String term){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SearchField));
        driver.findElement(SearchField).clear();
        driver.findElement(SearchField).sendKeys(term);


        driver.findElement(SearchField).sendKeys(Keys.ENTER);
    }

    public void ClickSearch(){

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.presenceOfElementLocated(SearchBtn));


            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(SearchBtn));
        } catch (Exception e) {

        }
    }

    public void SelectCategory(String categoryName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(CategoryDropdownToggle)).click();
        Thread.sleep(1000);
        By CategoryOption = By.xpath("//a[contains(text(), '" + categoryName + "')]");
        driver.findElement(CategoryOption).click();
    }
}