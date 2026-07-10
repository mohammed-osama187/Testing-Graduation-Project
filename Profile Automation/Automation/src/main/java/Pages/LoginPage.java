package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By emailField = By.id("input-email");
    By passwordField = By.id("input-password");
    By loginbtn = By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/form/input");
    By homebtn = By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[1]/a");

    public void login(String username, String password) {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        driver.findElement(emailField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginbtn).click();
        driver.findElement(homebtn).click();

    }
}
