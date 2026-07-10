package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComparePage extends Pages.BasePage {

    public ComparePage(WebDriver driver) {
        super(driver);
    }

    By Comparebtn = By.cssSelector("#entry_217823 > a > span > svg");
    By RemoveBtn = By.xpath("//*[@id=\"content\"]/table/tbody[2]/tr/td[2]/a");
    By Homebtn = By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[1]/a");
    By Addtocartbtn = By.cssSelector("#content > table > tbody:nth-child(3) > tr > td:nth-child(2) > input");
    By Continuebtn = By.cssSelector("#content > div > div > a");
    By Cartbtn = By.cssSelector("#entry_217825 > a > div.cart-icon > span");

    public void RemoveProductFromCompare() {
        driver.findElement(Homebtn).click();
        driver.findElement(Comparebtn).click();
        driver.findElement(Addtocartbtn).click();
        driver.findElement(RemoveBtn).click();
        driver.findElement(Continuebtn).click();
        driver.findElement(Cartbtn).click();
    }
}
