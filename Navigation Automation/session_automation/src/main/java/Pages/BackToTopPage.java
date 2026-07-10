package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BackToTopPage {
    WebDriver driver;
    WebDriverWait wait;

    public BackToTopPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By backToTopButton = By.xpath("//*[contains(@class, 'back-to-top') or @id='back-to-top' or contains(@title, 'Top')]");

    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    public void clickBackToTop() {
        wait.until(ExpectedConditions.elementToBeClickable(backToTopButton)).click();

        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    public boolean isPageAtTop() {
        Long scrollPosition = (Long) ((JavascriptExecutor) driver).executeScript("return window.pageYOffset;");
        return scrollPosition == 0;
    }
}