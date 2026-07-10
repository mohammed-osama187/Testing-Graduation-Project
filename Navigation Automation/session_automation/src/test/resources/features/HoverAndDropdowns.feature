@HoverMenu
Feature: Hover Menus and Dropdowns

  Background:
    Given the user opens the browser and navigates to the e-commerce site

  Scenario: Verify Shop by Category menu display
    When the user clicks on the Shop by Category button
    Then a vertical list of primary categories should be displayed

  Scenario: Verify Mega Menu opens correctly on hover
    When the user hovers over the Mega Menu link
    Then a multi-column dropdown should appear