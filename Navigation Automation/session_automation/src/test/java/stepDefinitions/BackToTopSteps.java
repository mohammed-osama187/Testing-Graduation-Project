package stepDefinitions;

import Pages.BackToTopPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class BackToTopSteps {
    BackToTopPage backToTopPage;

    @When("the user scrolls to the bottom of the page")
    public void scrollToBottom() {
        backToTopPage = new BackToTopPage(GlobalNav_Tests.driver);
        backToTopPage.scrollToBottom();
    }

    @And("clicks the Back to Top button")
    public void clickButton() {
        backToTopPage.clickBackToTop();
    }

    @Then("the page should scroll back to the top")
    public void verifyScrollToTop() {
        Assert.assertTrue(backToTopPage.isPageAtTop(), "The page did not scroll back to the top!");
    }
}