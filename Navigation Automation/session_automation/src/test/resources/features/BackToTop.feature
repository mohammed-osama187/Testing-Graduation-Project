@BackToTop

Feature: Back to Top Button Functionality

  Scenario: Verify the Back to Top button scrolls the page to the top
    Given the user navigates to the home page for global navigation tests
    When the user scrolls to the bottom of the page
    And clicks the Back to Top button
    Then the page should scroll back to the top