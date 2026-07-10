package stepDefinitions;

import Pages.Checkout;
import Pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckoutTests {
    WebDriver driver;
    HomePage homePage ;
    Checkout checkout;

    @Given("the user is on the checkout page with items in the cart")
    public void setUp() throws InterruptedException {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://ecommerce-playground.lambdatest.io/");
        homePage = new HomePage(driver);
        homePage.Add();
        checkout = new Checkout(driver);
        checkout.GotoCheckout();
    }

    @When("the user selects guest checkout and fills guest details with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, and {string}")
    public void GuestCheckout(String FirstName, String LastName, String Email, String Telephone, String Company, String Address1, String Address2, String City, String PostCode, String Country, String Region) throws InterruptedException {
        checkout = new Checkout(driver);
        checkout.FillGuest(FirstName,LastName,Email,Telephone,Company,Address1,Address2,City,PostCode,Country,Region);
    }

    @When("chooses to ship to a different address And fills alternative shipping details with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, and {string}")
    public void ChooseDifferentShippingAddress(String FirstName, String LastName, String Company, String Address1, String Address2, String City, String PostCode, String Country, String Region){
        checkout = new Checkout(driver);
        checkout.FillDifferentShipping(FirstName,LastName,Company,Address1,Address2,City,PostCode,Country,Region);
    }

    @When("the user selects guest checkout and fills guest details with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void GuestCheckout2(String FirstName, String LastName, String Email, String Telephone, String Company, String Address1, String Address2, String City, String PostCode, String Country, String Region) throws InterruptedException {
        checkout = new Checkout(driver);
        checkout.FillGuest(FirstName,LastName,Email,Telephone,Company,Address1,Address2,City,PostCode,Country,Region);
    }

    @When("inputs the comment {string}")
    public void AddComment(String Comment){
        checkout = new Checkout(driver);
        checkout.AddComment(Comment);
    }

    @When("the user selects register account checkout And fills registration details with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, and {string}")
    public void RegisterCheckout(String FirstName, String LastName, String Email, String Telephone, String Password, String ConfirmPassword, String Company, String Address1, String Address2, String City, String PostCode, String Country, String Region) {
        checkout = new Checkout(driver);
        if (Email.equalsIgnoreCase("RANDOM")) {
            Email = "user_" + System.currentTimeMillis() + "@gmail.com";
        }
        checkout.FillRegister(FirstName,LastName,Email,Telephone,Password,ConfirmPassword,Company,Address1,Address2,City,PostCode,Country,Region);
    }

    @When("the user logs in with email {string} and password {string}")
    public void LoginCheckout(String email, String password){
        checkout = new Checkout(driver);
        checkout.FillLogin(email,password);
    }

    @When("completes login checkout using existing billing address with telephone {string}")
    public void CompleteLoginWithExistingAddress(String tel){
        checkout = new Checkout(driver);
        checkout.CompleteLoginWithExistBillingAddress(tel);
    }

    @When("completes login checkout with a new billing address using {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, and {string}")
    public void CompleteLoginWithNewAddress(String FirstName, String LastName, String Telephone, String Company, String Address1, String Address2, String City, String PostCode, String Country, String Region){
        checkout = new Checkout(driver);
        checkout.CompleteLoginWithNewBillingAddress(FirstName,LastName,Telephone,Company,Address1,Address2,City,PostCode,Country,Region);
    }

    @When("the user selects guest checkout And fills guest details with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void InvalidGuestCheckout(String FirstName, String LastName, String Email, String Telephone, String Company, String Address1, String Address2, String City, String PostCode, String Country, String Region) throws InterruptedException {
        checkout = new Checkout(driver);
        checkout.FillGuest(FirstName,LastName,Email,Telephone,Company,Address1,Address2,City,PostCode,Country,Region);
    }

    @When("the user selects register account checkout And fills registration details with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void RegisterWithPasswordMismatch(String FirstName, String LastName, String Email, String Telephone, String Password, String ConfirmPassword, String Company, String Address1, String Address2, String City, String PostCode, String Country, String Region) {
        checkout = new Checkout(driver);
        checkout.FillRegister(FirstName,LastName,Email,Telephone,Password,ConfirmPassword,Company,Address1,Address2,City,PostCode,Country,Region);
    }

    @When("the user updates the product quantity to {string}")
    public void UpdateQuantity(String quantity){
        checkout = new Checkout(driver);
        checkout.UpdateQuantity(quantity);
    }

    @When("the user deletes the item from the checkout cart")
    public void DeleteItem(){
        checkout = new Checkout(driver);
        checkout.DeleteItem();
    }

    @When("handles optional preferences and terms")
    public void HandlesCheckboxes(){
        checkout = new Checkout(driver);
        checkout.checkBoxes();
    }

    @When("clicks the continue button")
    public void Continue(){
        checkout = new Checkout(driver);
        checkout.Continue();
    }

    @Then("the order should proceed to the next step")
    public void checkSuccess() {
        String expectedUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=extension/maza/checkout/confirm";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl);
    }

    @Then ("The field {string} should display the error message {string}")
    public void checkErrorMessage(String field, String errMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        checkout = new Checkout(driver);

        String msg = switch (field) {
            case "firstname" ->
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"account-detail\"]/div[2]/div/div"))).getText();
            case "lastname" ->
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"account-detail\"]/div[3]/div/div"))).getText();
            case "email" ->
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"account-detail\"]/div[4]/div/div"))).getText();
            case "telephone" ->
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"account-detail\"]/div[5]/div/div"))).getText();
            case "address-1" ->
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"payment-address\"]/div[2]/div/div"))).getText();
            case "city" ->
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"payment-address\"]/div[4]/div/div"))).getText();
            default -> "";
        };

        Assert.assertEquals(msg, errMessage);
    }

    @Then("the field {string} should display the error message {string}")
    public void CheckPasswordValidation(String field, String errMsg) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        Thread.sleep(1000);

        checkout = new Checkout(driver);
        actions.scrollByAmount(0, 200).perform();

        String msg = switch (field) {
            case "confirm" ->
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"account-password\"]/div[2]/div/div"))).getText();
            case "password" ->
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"account-password\"]/div[1]/div/div"))).getText();
            default -> " ";
        };

        Assert.assertEquals(msg, errMsg);
    }

    @Then("the error message {string} should appear")
    public void CheckNotAgreeingUponTermsAndConditions(String errMSG){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#form-checkout > div.alert.alert-warning.alert-dismissible"))).getText();
        Assert.assertTrue(msg.contains(errMSG));
    }

    @Then("the system should react with {string}")
    public void CheckQuantityUpdate(String expected){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        checkout = new Checkout(driver);

        String curURL;
        String expectedUrl;
        switch (expected){
            case "User completes checkout successfully":
                checkout.Continue();
                expectedUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=extension/maza/checkout/confirm";
                wait.until(ExpectedConditions.urlToBe(expectedUrl));
                curURL = driver.getCurrentUrl();
                Assert.assertEquals(curURL, expectedUrl);
                break;
            case "User goes back to cart page":
                expectedUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=checkout/cart";
                wait.until(ExpectedConditions.urlToBe(expectedUrl));
                curURL = driver.getCurrentUrl();
                Assert.assertEquals(curURL, expectedUrl);
                break;
            default:
        }
    }

    @Then("the checkout cart should reflect that the item is removed")
    public void ConfirmDelete(){
        String expectedUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=checkout/cart";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl);
    }

    @After
    public void teardown() throws InterruptedException {
        if(driver != null) {
            Thread.sleep(1000);
            driver.quit();
        }
    }

}
