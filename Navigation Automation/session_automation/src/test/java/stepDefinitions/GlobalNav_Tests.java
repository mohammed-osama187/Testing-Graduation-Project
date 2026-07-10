package stepDefinitions;

import Pages.GlobalHeaderPage;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class GlobalNav_Tests {

   public static WebDriver driver;
    GlobalHeaderPage headerPage;

    @Given("the user navigates to the home page for global navigation tests")
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://ecommerce-playground.lambdatest.io/");
    }

    @When("the user clicks on the Blog link")
    public void clickBlog() {
        headerPage = new GlobalHeaderPage(driver);
        headerPage.clickOnBlog();
    }

    @When("the user clicks on the Special link")
    public void clickSpecial() {
        headerPage = new GlobalHeaderPage(driver);
        headerPage.clickOnSpecial();
    }

    @Then("the user should be redirected to the {string} page")
    public void verifyRedirect(String pageName) {
        Assert.assertTrue(driver.getTitle().contains(pageName));
    }


    @When("the user clicks on the My account dropdown")
    public void clickMyAccount() {
        headerPage = new Pages.GlobalHeaderPage(driver);
        headerPage.clickOnMyAccount();
    }

    @Then("the account options should be displayed")
    public void verifyMyAccountMenu() {
        headerPage = new Pages.GlobalHeaderPage(driver);
        org.testng.Assert.assertTrue(headerPage.isMyAccountMenuDisplayed());
    }

    @When("the user clicks on the Home link")
    public void clickHome() {
        headerPage = new Pages.GlobalHeaderPage(driver);
        headerPage.clickOnHomeLink();
    }

    @Then("the user should be redirected to the Home Page")
    public void verifyHomePageRedirect() {
        org.testng.Assert.assertTrue(driver.getCurrentUrl().contains("route=common/home"));
    }

    @After
    public void teardown() throws InterruptedException {
        if(driver != null) {
            Thread.sleep(1000);
            driver.quit();
        }
    }
}