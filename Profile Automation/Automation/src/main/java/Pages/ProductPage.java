package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends Pages.BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    By Productname = By.cssSelector("#mz-product-listing-image-37218399-0-1 > div > div.carousel-item.active > img");
    By Comparebtn = By.cssSelector("button.btn-compare.compare-106");
    By Wishlistbtn = By.cssSelector("button.btn-wishlist.wishlist-106");

    public void AddProductToCompuure() {
        Actions actions = new Actions(driver);

        WebElement product = wait.until(ExpectedConditions.presenceOfElementLocated(Productname));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);

        actions.moveToElement(product).build().perform();

        WebElement compareBtn = wait.until(ExpectedConditions.elementToBeClickable(Comparebtn));

        try {
            compareBtn.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", compareBtn);
        }
    }

    public void AddProductToWishlist() {
        Actions actions = new Actions(driver);

        WebElement product = wait.until(ExpectedConditions.presenceOfElementLocated(Productname));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);

        actions.moveToElement(product).build().perform();

        WebElement wishlist = wait.until(ExpectedConditions.elementToBeClickable(Wishlistbtn));

        try {
            wishlist.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", wishlist);
        }
    }
}
