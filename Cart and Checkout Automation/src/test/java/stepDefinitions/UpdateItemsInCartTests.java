package stepDefinitions;

import Pages.Cart;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class UpdateItemsInCartTests {
    WebDriver driver;

    Cart cart;

    @Given("user opens the browser and navigates to the e-commerce site")
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://ecommerce-playground.lambdatest.io/");
    }

    @When("the user adds a product from the Home Page and Navigate to Cart Page")
    public void AddToCart() throws InterruptedException {
        cart = new Cart(driver);
        cart.GotoCartAfterAdd();
    }

    @When("the user change the product quantity with {string} and click on update button")
    public void UpdateQuantity(String quantity){
        cart = new Cart(driver);
        cart.ChangeQuantity(quantity);
    }

    @When("the user clicks on delete button")
    public void DeleteItem(){
        cart = new Cart(driver);
        cart.DeleteItem();
    }

    @Then("the product quantity and total price are updated")
    public void CheckValid(){
        String TotalPrice = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[6]")).getText();
        double totalPrice = Double.parseDouble(TotalPrice.substring(1));
        String UnitPrice = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[5]")).getText();
        double unitPrice = Double.parseDouble(UnitPrice.substring(1));
        Assert.assertEquals(totalPrice, (unitPrice * 5));
    }

    @Then("error message should appear to the user")
    public void CheckLargeQuantity(){
        String ErrorMessage = driver.findElement(By.cssSelector("#checkout-cart > div.alert.alert-danger.alert-dismissible")).getText();
        Assert.assertTrue(ErrorMessage.contains("Products marked with *** are not available in the desired quantity or not in stock!"));
    }

    @Then("product should be removed from the cart")
    public void CheckZeroQuantity(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement CartEmptyMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content > p")));
        String cartEmptyMessage = CartEmptyMessage.getText();
        Assert.assertTrue(cartEmptyMessage.contains("Your shopping cart is empty!"));
    }

    @After
    public void teardown() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(1000);
            driver.quit();
        }
    }

}
