@GlobalNav
Feature: Global Header Navigation

  Background:
    Given the user navigates to the home page for global navigation tests

  Scenario: Navigate to Blog page
    When the user clicks on the Blog link
    Then the user should be redirected to the "Blog" page

  Scenario: Navigate to Special Offers page
    When the user clicks on the Special link
    Then the user should be redirected to the "Special" page






  Scenario: Verify My Account dropdown menu opens correctly
    When the user clicks on the My account dropdown
    Then the account options should be displayed

  Scenario: Verify Home link redirects to the Home Page
    When the user clicks on the Home link
    Then the user should be redirected to the Home Page