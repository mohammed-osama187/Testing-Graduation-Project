@MegaMenu
Feature: Mega Menu Internal Links Functionality

  Scenario: Verify navigation to Apple category from Mega Menu
    Given the user navigates to the home page for global navigation tests
    When the user hovers over the Mega Menu
    And clicks on the Apple category
    Then the user should be redirected to the Apple products page