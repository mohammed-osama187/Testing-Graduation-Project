package stepDefinitions;

import Pages.Cart;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class NavigateFromCartTests {
    WebDriver driver;
    Cart cart;

    @Given("user opens a browser and navigates to the e-commerce site")
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://ecommerce-playground.lambdatest.io/");
    }

    @When("user adds product from the Home Page and Navigate to Cart Page")
    public void AddToCart() throws InterruptedException {
        cart = new Cart(driver);
        cart.GotoCartAfterAdd();
    }

    @When("user clicks on Continue Shopping button")
    public void ContinueShopping(){
        cart = new Cart(driver);
        cart.ContinueShopping();
    }

    @When("user clicks on Checkout button")
    public void GoToCheckout(){
        cart = new Cart(driver);
        cart.GoToCheckout();
    }

    @Then("user is navigated to the homepage")
    public void CheckGoingBackToHomePage(){
        String curURL = driver.getCurrentUrl();
        Assert.assertEquals(curURL, "https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
    }

    @Then("user is navigated to the checkout")
    public void CheckGoingToCheckout(){
        String curURL = driver.getCurrentUrl();
        Assert.assertEquals(curURL, "https://ecommerce-playground.lambdatest.io/index.php?route=checkout/checkout");
    }

    @After
    public void teardown() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(1000);
            driver.quit();
        }
    }

}
