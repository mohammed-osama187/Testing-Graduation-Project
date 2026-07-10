package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By NextBtn = By.cssSelector("#mz-product-tab-37218399-0 > div > div.swiper-pager.custom-pager > a.swiper-button-next > div > svg");
    By HP_LP3065_Image = By.xpath("//div[contains(@class, 'product-thumb') and .//a[text()='HP LP3065']]//img");
    By HP_LP3065_AddToCartBtn = By.xpath("//div[contains(@class, 'product-thumb') and .//a[text()='HP LP3065']]//button[contains(@class, 'btn-cart')]");

    public void Add() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        try {
            while (true) {

                actions.scrollByAmount(0, 1000).perform();
                WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(NextBtn));
                if (btn.isDisplayed()) {

                    Thread.sleep(1000);

                    for (int i = 0; i < 4; i++) {
                        wait.until(ExpectedConditions.visibilityOfElementLocated(NextBtn)).click();
                    }

                    Thread.sleep(1000);

                    break;

                } else {
                    actions.scrollByAmount(0, 100).perform();
                }

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        WebElement elementToHover = wait.until(ExpectedConditions.visibilityOfElementLocated(HP_LP3065_Image));
        actions.moveToElement(elementToHover).perform();

        WebElement target = wait.until(ExpectedConditions.elementToBeClickable(HP_LP3065_AddToCartBtn));

        target.click();
    }
}