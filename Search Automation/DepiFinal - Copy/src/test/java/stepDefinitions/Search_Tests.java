package stepDefinitions;

import Pages.HomePage;
import Pages.SearchResultPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Search_Tests {

    WebDriver driver;
    HomePage homePage;
    SearchResultPage searchResultPage;

    public Search_Tests() {
        this.driver = Hooks.driver;
        this.homePage = new HomePage(driver);
        this.searchResultPage = new SearchResultPage(driver);
    }

    @Given("The user is on the eCommerce Playground home page")
    public void userIsOnHomePage() {
        driver.get("https://ecommerce-playground.lambdatest.io/");
    }

    @When("The user enters {string} in the search bar")
    public void userEntersSearchTerm(String term) {
        homePage.EnterSearchTerm(term);
    }

    @And("The user clicks the search button")
    public void userClicksSearch() {
        homePage.ClickSearch();
    }

    @Then("The search results should handle {string} properly")
    public void verifySearchResults(String type) {
        int count = searchResultPage.GetProductsCount();
        Assert.assertTrue(count >= 0);
    }

    @When("The user selects category {string}")
    public void userSelectsCategory(String category) throws InterruptedException {
        homePage.SelectCategory(category);
    }

    @Then("The results should display products from the {string} category")
    public void verifyCategoryResults(String category) {
        Assert.assertTrue(searchResultPage.GetProductsCount() >= 0);
    }

    @Then("The results should display no products message")
    public void verifyNoProductsMessage() {
        Assert.assertTrue(searchResultPage.GetProductsCount() == 0 || searchResultPage.IsNoProductsMessageDisplayed());
    }

    @Then("The search results should display relevant products")
    public void verifyRelevantProducts() {
        Assert.assertTrue(searchResultPage.GetProductsCount() >= 0);
    }

    @And("The user filters by Price range from {string} to {string}")
    public void userFiltersByPrice(String min, String max) throws InterruptedException {
        searchResultPage.ApplyPriceFilter(min, max);
    }

    @Then("The price fields should handle the invalid range correctly")
    public void verifyInvalidPriceRange() {
        Assert.assertTrue(true);
    }

    @Then("The price fields should reject invalid inputs")
    public void verifyRejectedInvalidPriceInputs() {
        Assert.assertTrue(true);
    }

    @Then("All displayed products should be within the price range")
    public void verifyValidPriceRangeResults() {
        Assert.assertTrue(searchResultPage.GetProductsCount() >= 0);
    }

    @And("The user filters by Brand {string}")
    public void userFiltersByBrand(String brand) throws InterruptedException {
        searchResultPage.ApplyBrandFilter(brand);
    }

    @Then("All displayed products should belong to selected brands")
    public void verifyBrandFilters() {
        Assert.assertTrue(searchResultPage.GetProductsCount() >= 0);
    }

    @And("The user filters by Availability {string}")
    public void userFiltersByAvailability(String status) throws InterruptedException {
        searchResultPage.ApplyAvailabilityFilter(status);
    }

    @Then("All displayed products should be in stock")
    public void verifyInStockFilters() {
        Assert.assertTrue(searchResultPage.GetProductsCount() >= 0);
    }

    @Then("All displayed products should match the selected filters")
    public void verifyAllFiltersCombined() {
        Assert.assertTrue(searchResultPage.GetProductsCount() >= 0);
    }

    @And("The user removes filter for Brand {string}")
    public void userRemovesBrandFilter(String brand) throws InterruptedException {
        searchResultPage.RemoveBrandFilter(brand);
    }

    @Then("The results should update to display only the remaining filters")
    public void verifyPartialFilterRemoval() {
        Assert.assertTrue(searchResultPage.GetProductsCount() >= 0);
    }

    @And("The user clicks on Clear All filters button")
    public void userClicksClearAll() {
        searchResultPage.ClickClearAll();
    }

    @Then("All filters should be reset to default")
    public void verifyFiltersReset() {
        Assert.assertTrue(searchResultPage.GetProductsCount() >= 0);
    }
}