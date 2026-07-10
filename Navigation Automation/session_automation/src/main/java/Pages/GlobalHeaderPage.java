package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GlobalHeaderPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public GlobalHeaderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    By blogLink = By.xpath("//ul[contains(@class, 'horizontal')]//a[contains(@href, 'blog/home')]");
    By specialLink = By.xpath("//ul[contains(@class, 'horizontal')]//a[contains(@href, 'special')]");

    By myAccountMenu = By.xpath("//a[contains(@href, 'route=account/account') and @data-toggle='dropdown']");
    By loginOption = By.xpath("//a[contains(@href, 'route=account/login')]//span[contains(text(), 'Login')]");
    By homeLink = By.xpath("//ul[contains(@class, 'horizontal')]//a[contains(@href, 'route=common/home')]");
    By megaMenuLink = By.xpath("//a[.//span[contains(text(),'Mega Menu')]]");
    By megaMenuDropdown = By.xpath("//ul[contains(@class, 'mega-menu-content')]");

    public void clickOnBlog() {
        wait.until(ExpectedConditions.elementToBeClickable(blogLink)).click();
    }

    public void clickOnSpecial() {
        wait.until(ExpectedConditions.elementToBeClickable(specialLink)).click();
    }

    public void hoverOverMegaMenu() {
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(megaMenuLink));
        actions.moveToElement(menu).perform();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isMegaMenuDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(megaMenuDropdown)).isDisplayed();
    }


    public void clickOnMyAccount() {
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(myAccountMenu));
        actions.moveToElement(menu).perform();

        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
    }
    public boolean isMyAccountMenuDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginOption)).isDisplayed();
    }

    public void clickOnHomeLink() {
        wait.until(ExpectedConditions.elementToBeClickable(homeLink)).click();
    }
}