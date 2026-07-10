package stepDefinitions;

import Pages.Cart;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Tha;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CouponAndGiftTests {
    WebDriver driver;
    Cart cart;

    @Given("user opened the browser and navigates to the e-commerce site")
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://ecommerce-playground.lambdatest.io/");
    }

    @When("the user adds a product from the Home Page and Navigates to the Cart Page")
    public void AddToCart() throws InterruptedException {
        cart = new Cart(driver);
        cart.GotoCartAfterAdd();
    }

    @When("the user open coupon section, enters {string} and click on Apply Coupon Button")
    public void EnterInvalidCoupon(String Coupon){
        cart = new Cart(driver);
        cart.AddCoupon(Coupon);
    }

    @When("the user open gift section, enters {string} and click on Apply Coupon Button")
    public void EnterInvalidGift(String Gift){
        cart = new Cart(driver);
        cart.AddGift(Gift);
    }

    @Then("Error message should appear to the user")
    public void InvalidCoupon(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement ErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapse-coupon > div > div.alert.alert-danger.alert-dismissible")));
        String errorMessage = ErrorMessage.getText();
        Assert.assertTrue(errorMessage.contains("Warning: Coupon is either invalid, expired or reached its usage limit!"));
    }

    @Then("Warning message should appear to the user")
    public void EmptyCoupon(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement ErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapse-coupon > div > div.alert.alert-danger.alert-dismissible")));
        String errorMessage = ErrorMessage.getText();
        Assert.assertTrue(errorMessage.contains("Warning: Please enter a coupon code!"));
    }

    @Then("Warning message should appear to user")
    public void EmptyGift(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement ErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapse-voucher > div > div.alert.alert-danger.alert-dismissible")));
        String errorMessage = ErrorMessage.getText();
        Assert.assertTrue(errorMessage.contains("Warning: Please enter a gift certificate code!"));
    }

    @Then("Error message should appear to user")
    public void InvalidGift(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement ErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapse-voucher > div > div.alert.alert-danger.alert-dismissible")));
        String errorMessage = ErrorMessage.getText();
        Assert.assertTrue(errorMessage.contains("Warning: Gift Certificate is either invalid or the balance has been used up!"));
    }

    @After
    public void teardown() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(1000);
            driver.quit();
        }
    }
}
