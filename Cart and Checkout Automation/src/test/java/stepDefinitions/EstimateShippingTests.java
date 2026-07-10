package stepDefinitions;

import Pages.Cart;
import io.cucumber.java.After;
import io.cucumber.java.PendingException;
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

public class EstimateShippingTests {
    WebDriver driver;
    Cart cart;

    @Given("user opens browser and navigates to the e-commerce site")
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://ecommerce-playground.lambdatest.io/");
    }

    @When("the user adds product from the Home Page and Navigate to Cart Page")
    public void AddToCart() throws InterruptedException {
        cart = new Cart(driver);
        cart.GotoCartAfterAdd();
    }

    @When("the user opens estimate shipping section, choose {string} and {string} and {string} , choose flat rate, and click apply")
    public void EstimateShippingSuccess(String country,String state,String postalCode) throws InterruptedException {
        cart = new Cart(driver);
        cart.EstimateShipping(country,state,postalCode);
        cart.applyFlatShipping();
    }

    @When("the user opens estimate shipping section, choose {string} and {string} and {string} , choose flat rate, and click cancel")
    public void CancelShippingSuccess(String country,String state,String postalCode) throws InterruptedException {
        cart = new Cart(driver);
        cart.EstimateShipping(country,state,postalCode);
        cart.CancelEstimateShipping();
    }

    @When("the user opens estimate shipping section, choose {string} and {string} and {string}")
    public void EstimateShippingFail(String country,String state,String postalCode) throws InterruptedException {
        cart = new Cart(driver);
        cart.EstimateShipping(country,state,postalCode);
    }

    @Then("flat rate shipping should be applied")
    public void ShippingApplied(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement SuccessMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checkout-cart > div.alert.alert-success.alert-dismissible")));
        String successMessage = SuccessMessage.getText();
        Assert.assertTrue(successMessage.contains("Success: Your shipping estimate has been applied!"));
    }

    @Then("flat rate shipping should NOT be applied")
    public void ShippingCanceled(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement _total = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/table/tbody/tr[4]/td[2]")));
        String Total = _total.getText();
        Assert.assertEquals(Total, "$122.00");
    }

    @Then("Error message 'Please select a country!' should appear")
    public void CheckInvalid_EmptyCountry(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapse-shipping > div > div:nth-child(1) > div > div")));
        String errorMessage = ErrorMessage.getText();
        Assert.assertTrue(errorMessage.contains("Please select a country!"));
    }

    @Then("Error message {string} should appear to user")
    public void CheckInvalid_EmptyState(String ErrMsg){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapse-shipping > div > div:nth-child(2) > div > div")));
        String errorMessage = ErrorMessage.getText();
        Assert.assertTrue(errorMessage.contains(ErrMsg));
    }

    @Then("Error message 'Postcode must be between 2 and 10 characters!' should appear")
    public void CheckInvalid_UkWithEmptyPostCode(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapse-shipping > div > div:nth-child(3) > div > div")));
        String errorMessage = ErrorMessage.getText();
        Assert.assertTrue(errorMessage.contains("Postcode must be between 2 and 10 characters!"));
    }


    @After
    public void teardown() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(1000);
            driver.quit();
        }
    }

}
