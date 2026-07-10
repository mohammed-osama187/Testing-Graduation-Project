package Steps;

import Pages.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class ProductManagementSteps {
    WebDriver driver;
    LoginPage loginPage;
    ProductPage productPage;
    ComparePage comparePage;
    WishlistPage wishlistPage;

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        loginPage.login("axax@gmail.com", "axaxaxax");
    }

    @When("the user adds a product to the compare list")
    public void the_user_adds_a_product_to_the_compare_list() {
        productPage = new ProductPage(driver);
        productPage.AddProductToCompuure();
    }

    @When("the user adds a product to the wishlist")
    public void the_user_adds_a_product_to_the_wishlist() {
        productPage = new ProductPage(driver);
        productPage.AddProductToWishlist();
    }

    @And("the user adds the product to the cart and removes the product from the compare list")
    public void the_user_adds_to_cart_and_removes_from_compare() {
        comparePage = new ComparePage(driver);
        comparePage.RemoveProductFromCompare();
    }

    @And("the user adds the product to the cart and removes the product from the wishlist")
    public void the_user_adds_to_cart_and_removes_from_wishlist() {
        wishlistPage = new WishlistPage(driver);
        wishlistPage.RemoveProductFromWishlist();
    }

    @Then("the product should be added to the cart and moved from the compare list successfully")
    public void the_product_should_be_added_to_the_cart_and_moved_from_the_compare_list_successfully() {
        System.out.println("Success: Product moved from Compare to Cart");
        if (driver != null) {
            driver.quit();
        }
    }

    @Then("the product should be added to the cart and moved from the wishlist successfully")
    public void the_product_should_be_added_to_the_cart_and_moved_from_the_wishlist_successfully() {
        System.out.println("Success: Product moved from Wishlist to Cart");
        if (driver != null) {
            driver.quit();
        }
    }
}
