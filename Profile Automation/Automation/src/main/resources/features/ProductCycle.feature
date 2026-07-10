Feature: Product Management Cycle

  Scenario: Add and Remove product from Compare list
    Given the user is logged in
    When the user adds a product to the compare list
    And the user adds the product to the cart and removes the product from the compare list
    Then the product should be added to the cart and moved from the compare list successfully

  Scenario: Add and Remove product from Wishlist
    Given the user is logged in
    When the user adds a product to the wishlist
    And the user adds the product to the cart and removes the product from the wishlist
    Then the product should be added to the cart and moved from the wishlist successfully