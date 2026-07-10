package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CategoryMenuPage {
    WebDriver driver;
    WebDriverWait wait;

    public CategoryMenuPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By shopByCategoryBtn = By.xpath("//a[contains(.,'Shop by Category')]");
    By categoryDropdown = By.cssSelector("#widget-navbar-217841");

    public void clickShopByCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(shopByCategoryBtn)).click();
    }

    public boolean isCategoryMenuDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(categoryDropdown)).isDisplayed();
    }
}