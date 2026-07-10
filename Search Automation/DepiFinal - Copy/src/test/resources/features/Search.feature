Feature: Search and Advanced Filtering Functionality

  Background:
    Given The user is on the eCommerce Playground home page

  Scenario Outline: Verify text search with various inputs including edge and security test cases
    When The user enters "<search_term>" in the search bar
    And The user clicks the search button
    Then The search results should handle "<type>" properly

    Examples:
      | search_term                                                                                       | type               |
      | Mac                                                                                               | Partial Search     |
      | iphone                                                                                            | Case S_lowercase   |
      | IPHONE                                                                                            | Case S_uppercase   |
      | Samung                                                                                            | Misspelling        |
      |                                                                                                   | White spaces       |
      | @#$%^&* | Special Characters |
      | <script>alert('xss')</script>                                                                     | XSS Injection      |
      | ' OR 1=1                                                                                          | SQL Injection      |
      | abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqr | Long String        |

  Scenario: Verify compatible search within specific category
    When The user selects category "Laptops"
    And The user enters "MacBook" in the search bar
    And The user clicks the search button
    Then The results should display products from the "Laptops" category

  Scenario: Verify incompatible search within specific category
    When The user selects category "Cameras"
    And The user enters "MacBook" in the search bar
    And The user clicks the search button
    Then The results should display no products message

  Scenario: Verify general search across all categories
    When The user enters "iMac" in the search bar
    And The user clicks the search button
    Then The search results should display relevant products

  Scenario: Verify price filter with invalid inputs like min greater than max
    When The user enters "Phone" in the search bar
    And The user clicks the search button
    And The user filters by Price range from "1000" to "500"
    Then The price fields should handle the invalid range correctly

  Scenario: Verify price filter with negative numbers and alphabetic characters
    When The user enters "Phone" in the search bar
    And The user clicks the search button
    And The user filters by Price range from "-100" to "abc"
    Then The price fields should reject invalid inputs

  Scenario: Verify product display within valid price range
    When The user enters "Phone" in the search bar
    And The user clicks the search button
    And The user filters by Price range from "100" to "500"
    Then All displayed products should be within the price range

  Scenario: Verify filtering by single and multiple brands
    When The user enters "Phone" in the search bar
    And The user clicks the search button
    And The user filters by Brand "Apple"
    And The user filters by Brand "HTC"
    Then All displayed products should belong to selected brands

  Scenario: Verify filtering by availability status
    When The user enters "Phone" in the search bar
    And The user clicks the search button
    And The user filters by Availability "In Stock"
    Then All displayed products should be in stock

  Scenario: Verify complete combination of multiple advanced filters
    When The user enters "Phone" in the search bar
    And The user clicks the search button
    And The user filters by Brand "Apple"
    And The user filters by Price range from "500" to "1000"
    And The user filters by Availability "In Stock"
    Then All displayed products should match the selected filters

  Scenario: Verify partial removal of applied filters
    When The user enters "Phone" in the search bar
    And The user clicks the search button
    And The user filters by Brand "Apple"
    And The user filters by Brand "HTC"
    And The user removes filter for Brand "Apple"
    Then The results should update to display only the remaining filters

  Scenario: Verify clear all filters functionality
    When The user enters "Phone" in the search bar
    And The user clicks the search button
    And The user filters by Brand "Apple"
    And The user clicks on Clear All filters button
    Then All filters should be reset to default