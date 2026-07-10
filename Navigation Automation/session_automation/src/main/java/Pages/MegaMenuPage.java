package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MegaMenuPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public MegaMenuPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    By megaMenuDropdown = By.xpath("//a[contains(normalize-space(), 'Mega Menu')]");
    By appleLink = By.xpath("//a[contains(@title, 'Apple') or contains(text(), 'Apple')]");

    public void hoverOverMegaMenu() {
        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(megaMenuDropdown));
        actions.moveToElement(menu).perform();

        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    public void clickOnAppleCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(appleLink)).click();
    }
}