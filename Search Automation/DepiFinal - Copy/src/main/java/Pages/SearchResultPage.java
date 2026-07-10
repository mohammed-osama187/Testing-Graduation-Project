package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SearchResultPage {

    WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    By MinPriceField = By.cssSelector("input[name='mz_fp[min]']");
    By MaxPriceField = By.cssSelector("input[name='mz_fp[max]']");
    By ClearAllFiltersBtn = By.cssSelector("a.mz-filter-reset-all");
    By ProductItems = By.cssSelector(".product-layout");
    By NoProductsMessage = By.xpath("//div[@id='content']/p[contains(text(),'There is no product')]");

    public void ApplyPriceFilter(String min, String max) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MinPriceField));
        driver.findElement(MinPriceField).clear();
        driver.findElement(MinPriceField).sendKeys(min);
        driver.findElement(MaxPriceField).clear();
        driver.findElement(MaxPriceField).sendKeys(max);
        Thread.sleep(2000);
    }

    public void ApplyBrandFilter(String brandName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By BrandCheckbox = By.xpath("//label[contains(text(),'" + brandName + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(BrandCheckbox)).click();
        Thread.sleep(2000);
    }

    public void RemoveBrandFilter(String brandName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By BrandCheckbox = By.xpath("//label[contains(text(),'" + brandName + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(BrandCheckbox)).click();
        Thread.sleep(2000);
    }

    public void ApplyAvailabilityFilter(String status) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By AvailabilityCheckbox = By.xpath("//label[contains(text(),'" + status + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(AvailabilityCheckbox)).click();
        Thread.sleep(2000);
    }

    public void ClickClearAll(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ClearAllFiltersBtn)).click();
    }

    public int GetProductsCount(){
        return driver.findElements(ProductItems).size();
    }

    public boolean IsNoProductsMessageDisplayed() {
        return driver.findElements(NoProductsMessage).size() > 0;
    }

    public String GetMinPriceValue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MinPriceField));
        return driver.findElement(MinPriceField).getAttribute("value");
    }

    public String GetMaxPriceValue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MaxPriceField));
        return driver.findElement(MaxPriceField).getAttribute("value");
    }
}