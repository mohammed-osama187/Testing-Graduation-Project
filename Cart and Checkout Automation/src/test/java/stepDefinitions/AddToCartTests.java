package stepDefinitions;

import Pages.HomePage;
import Pages.PDP;
import Pages.PLP;
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

public class AddToCartTests {

    WebDriver driver;
    PDP PDP;
    PLP PLP;
    HomePage homePage;

    @Given("the user opens the browser and navigates to the e-commerce site")
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://ecommerce-playground.lambdatest.io/");
    }

    @When("the user adds a product from the Home Page")
    public void addFromHomePage() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.Add();
    }

    @When("the user navigates to PDP and adds a product")
    public void addFromPDP() throws InterruptedException {
        PDP = new PDP(driver);
        PDP.GoToPDP();
        PDP.AddFromPDP("1");
    }

    @When("the user navigates to PLP and adds a product")
    public void addFromPLP() {
        PLP = new PLP(driver);
        PLP.GoToPLP();
        PLP.AddFromPLP();
    }

    @When("the user navigates to PDP and adds a product with negative quantity")
    public void addFromPDPInvalid() throws InterruptedException {
        PDP = new PDP(driver);
        PDP.GoToPDP();
        PDP.AddFromPDP("-1");

    }

    @Then("the cart count should display {string}")
    public void verifyCartCount(String expectedCount) throws InterruptedException {
        WebElement cartCountElement = driver.findElement(By.xpath("//*[@id=\"entry_217825\"]/a/div[1]/span"));
        Thread.sleep(1000);
        String actualCount = cartCountElement.getText();
        Assert.assertEquals(actualCount, expectedCount);
    }

    @Then("the item should not be added to the cart")
    public void verifyCartNotChanged() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement SuccessMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#notification-box-top > div > div.toast-body")));
        Assert.assertFalse(SuccessMessage.isDisplayed());
    }

    @After
    public void teardown() throws InterruptedException {
        if(driver != null) {
            Thread.sleep(1000);
            driver.quit();
        }
    }

}
