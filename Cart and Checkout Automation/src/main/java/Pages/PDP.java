package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PDP {
    WebDriver driver;

    public PDP(WebDriver driver) {
        this.driver = driver;
    }

    By NextBtn = By.cssSelector("#mz-product-tab-37218399-0 > div > div.swiper-pager.custom-pager > a.swiper-button-next > div > svg");
    By HP_LP3065 = By.xpath("(//div[contains(@class, 'product-thumb')]//h4/a)[9]");
    By AddToCartBtn = By.cssSelector("#entry_216842 > button");
    By QuantityField = By.cssSelector("#entry_216841 > div > input");

    public void GoToPDP() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        actions.scrollByAmount(0, 1500).perform();
        Thread.sleep(1000);

        for (int i = 0; i < 4; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(NextBtn)).click();
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(HP_LP3065));
        driver.findElement(HP_LP3065).click();
    }

    public void AddFromPDP(String quantity){
        WebElement quantityField = driver.findElement(QuantityField);
        quantityField.clear();
        quantityField.sendKeys(quantity);
        driver.findElement(AddToCartBtn).click();
    }

}