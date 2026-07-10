package stepDefinitions;

import Pages.CategoryMenuPage;
import Pages.GlobalHeaderPage;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class HoverMenus_Tests {

    WebDriver driver;
    CategoryMenuPage categoryPage;
    GlobalHeaderPage headerPage;

    @Given("the user opens the browser and navigates to the e-commerce site")
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://ecommerce-playground.lambdatest.io/");
    }

    @When("the user clicks on the Shop by Category button")
    public void clickCategoryBtn() {
        categoryPage = new CategoryMenuPage(driver);
        categoryPage.clickShopByCategory();
    }

    @Then("a vertical list of primary categories should be displayed")
    public void verifyCategoryMenu() {
        Assert.assertTrue(categoryPage.isCategoryMenuDisplayed());
    }

    @When("the user hovers over the Mega Menu link")
    public void hoverMegaMenu() {
        headerPage = new GlobalHeaderPage(driver);
        headerPage.hoverOverMegaMenu();
    }

    @Then("a multi-column dropdown should appear")
    public void verifyMegaMenu() {
        Assert.assertTrue(headerPage.isMegaMenuDisplayed());
    }

    @After
    public void teardown() throws InterruptedException {
        if(driver != null) {
            Thread.sleep(1000);
            driver.quit();
        }
    }
}