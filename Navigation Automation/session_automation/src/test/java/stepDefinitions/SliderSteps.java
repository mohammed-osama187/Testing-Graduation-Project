package stepDefinitions;

import Pages.SliderPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class SliderSteps {
    SliderPage sliderPage;
    String firstImageSrc;

    @When("the user observes the current slide")
    public void observeCurrentSlide() {
        sliderPage = new SliderPage(GlobalNav_Tests.driver);
        firstImageSrc = sliderPage.getActiveSlideImageSrc();
    }

    @And("the user clicks on the next slide button")
    public void clickNextButton() {
        sliderPage.clickNextSlide();

        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    @Then("the slider should display the next image")
    public void verifyNextSlide() {
        String secondImageSrc = sliderPage.getActiveSlideImageSrc();

        Assert.assertNotEquals(firstImageSrc, secondImageSrc, "The slider image did not change!");
    }
}