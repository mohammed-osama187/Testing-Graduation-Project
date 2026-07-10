package stepDefinitions;

import Pages.Cart;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class CartTests {

    WebDriver driver;
    Cart cart ;

    @Given("the user opened the browser and navigates to the e-commerce site")
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://ecommerce-playground.lambdatest.io/");
    }

    @When("the user clicks on cart button and click on edit cart")
    public void GoToCart(){
        cart = new Cart(driver);
        cart.GoToCart();
    }

    @When("the user adds a product ro cart and click on Go to Cart button")
    public void GoToCartAfterAdd() throws InterruptedException {
        cart = new Cart(driver);
        cart.GotoCartAfterAdd();
    }

    @Then("the user should be redirected to the cart page")
    public void check(){
        String CurURL = driver.getCurrentUrl();
        Assert.assertEquals(CurURL,"https://ecommerce-playground.lambdatest.io/index.php?route=checkout/cart");
    }

    @After
    public void teardown() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(1000);
            driver.quit();
        }
    }

}
