package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PLP {
    WebDriver driver;

    public PLP(WebDriver driver) {
        this.driver = driver;
    }

    By Mega_Menu = By.cssSelector("#widget-navbar-217834 > ul > li.nav-item.dropdown.dropdown-hoverable.mega-menu.position-static > a > div > span");
    By Apple = By.cssSelector("#entry281_216477 > div > div > ul > li:nth-child(1) > a");
    By IPad_Nano = By.xpath("//*[@id=\"mz-product-grid-image-57-212439\"]/div/div[1]/img");
    By IPad_Nano_AddToCartBtn = By.xpath("//*[@id=\"entry_212439\"]/div/div[15]/div/div[1]/div[2]/button[1]");

    public void GoToPLP(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elementToHover = driver.findElement(Mega_Menu);
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
        WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(Apple));
        actions.moveToElement(target).click().perform();
    }

    public void AddFromPLP(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(IPad_Nano));
        WebElement elementToHover = driver.findElement(IPad_Nano);
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(IPad_Nano_AddToCartBtn));
        WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(IPad_Nano_AddToCartBtn));
        actions.moveToElement(target).click().perform();
    }

}