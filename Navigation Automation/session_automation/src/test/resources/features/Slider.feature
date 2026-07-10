@Slider
Feature: Home Page Banner Slider

  Scenario: Verify the slider moves to the next image when clicking the next button
    Given the user navigates to the home page for global navigation tests
    When the user observes the current slide
    And the user clicks on the next slide button
    Then the slider should display the next image