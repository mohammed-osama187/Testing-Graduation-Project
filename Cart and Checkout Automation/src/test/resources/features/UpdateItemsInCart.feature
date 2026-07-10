@UpdateItemsInCart
  Feature: Update the quantity of the product in the cart

    Scenario: Update quantity with valid number
      Given user opens the browser and navigates to the e-commerce site
      When the user adds a product from the Home Page and Navigate to Cart Page
      And the user change the product quantity with "5" and click on update button
      Then the product quantity and total price are updated

    Scenario: Update quantity with very large number
      Given user opens the browser and navigates to the e-commerce site
      When the user adds a product from the Home Page and Navigate to Cart Page
      And the user change the product quantity with "999999999" and click on update button
      Then error message should appear to the user

    Scenario: Update quantity with Negative number
      Given user opens the browser and navigates to the e-commerce site
      When the user adds a product from the Home Page and Navigate to Cart Page
      And the user change the product quantity with "-1" and click on update button
      Then error message should appear to the user

    Scenario: Update quantity with 0
      Given user opens the browser and navigates to the e-commerce site
      When the user adds a product from the Home Page and Navigate to Cart Page
      And the user change the product quantity with "0" and click on update button
      Then product should be removed from the cart

    Scenario: Remove item from the Cart
      Given user opens the browser and navigates to the e-commerce site
      When the user adds a product from the Home Page and Navigate to Cart Page
      And the user clicks on delete button
      Then product should be removed from the cart