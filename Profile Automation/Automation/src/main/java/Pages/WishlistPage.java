package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage extends Pages.BasePage {

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    By Wishlistbtn = By.cssSelector("#entry_217824 > a > span > svg");
    By RemoveBtn = By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/a/i");
    By Homebtn = By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[1]/a");
    By Addtocartbtn = By.cssSelector("#content > div.table-responsive > table > tbody > tr > td.text-right.text-nowrap > button > i");
    By Continuebtn = By.cssSelector("#content > div.buttons.clearfix.mb-4 > div > a");
    By Cartbtn = By.cssSelector("#entry_217825 > a > div.cart-icon > span");

    public void RemoveProductFromWishlist() {
        driver.findElement(Homebtn).click();
        driver.findElement(Wishlistbtn).click();
        driver.findElement(Addtocartbtn).click();
        driver.findElement(RemoveBtn).click();
        driver.findElement(Continuebtn).click();
        driver.findElement(Cartbtn).click();
    }
}
