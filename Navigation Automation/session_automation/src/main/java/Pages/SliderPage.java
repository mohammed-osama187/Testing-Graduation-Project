package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SliderPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public SliderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    By activeSlideImage = By.cssSelector(".swiper-slide-active img");
    By nextButton = By.cssSelector(".swiper-button-next");

    public String getActiveSlideImageSrc() {
        WebElement activeImage = wait.until(ExpectedConditions.visibilityOfElementLocated(activeSlideImage));
        return activeImage.getAttribute("outerHTML");
    }

    public void clickNextSlide() {
        WebElement activeImage = wait.until(ExpectedConditions.visibilityOfElementLocated(activeSlideImage));
        actions.moveToElement(activeImage).perform();

        try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }

        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }
}