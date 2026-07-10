@NavigateToCart
Feature: Add Products to Cart And Navigating to Cart

  Scenario: Navigate to Cart
    Given the user opened the browser and navigates to the e-commerce site
    When the user clicks on cart button and click on edit cart
    Then the user should be redirected to the cart page

  Scenario: Navigate to Cart
    Given the user opened the browser and navigates to the e-commerce site
    When the user adds a product ro cart and click on Go to Cart button
    Then the user should be redirected to the cart page