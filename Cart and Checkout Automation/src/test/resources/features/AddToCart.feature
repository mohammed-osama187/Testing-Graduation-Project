@AddToCart
Feature: Add Products to Cart

  Scenario: Add product from Home Page
    Given the user opens the browser and navigates to the e-commerce site
    When the user adds a product from the Home Page
    Then the cart count should display "1"

  Scenario: Add product from Product Detail Page (PDP)
    Given the user opens the browser and navigates to the e-commerce site
    When the user navigates to PDP and adds a product
    Then the cart count should display "1"

  Scenario: Invalid Add product from Product Detail Page (PDP)
    Given the user opens the browser and navigates to the e-commerce site
    When the user navigates to PDP and adds a product with negative quantity
    Then the item should not be added to the cart

  Scenario: Add product from Product Listing Page (PLP)
    Given the user opens the browser and navigates to the e-commerce site
    When the user navigates to PLP and adds a product
    Then the cart count should display "1"