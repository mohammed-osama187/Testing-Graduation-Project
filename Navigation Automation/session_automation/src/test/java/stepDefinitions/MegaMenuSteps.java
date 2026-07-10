package stepDefinitions;

import Pages.MegaMenuPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class MegaMenuSteps {
    MegaMenuPage megaMenuPage;

    @When("the user hovers over the Mega Menu")
    public void hoverMegaMenu() {
        megaMenuPage = new MegaMenuPage(GlobalNav_Tests.driver);
        megaMenuPage.hoverOverMegaMenu();
    }

    @And("clicks on the Apple category")
    public void clickApple() {
        megaMenuPage.clickOnAppleCategory();
    }

    @Then("the user should be redirected to the Apple products page")
    public void verifyApplePage() {
        Assert.assertTrue(GlobalNav_Tests.driver.getTitle().contains("Apple"));
    }
}