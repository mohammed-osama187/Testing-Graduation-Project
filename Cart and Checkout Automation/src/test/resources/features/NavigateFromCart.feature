@NavigateFromCart
  Feature: User Can Go back to Continue Shopping or Go to Checkout

    Scenario: User Go back to shopping
      Given user opens a browser and navigates to the e-commerce site
      When user adds product from the Home Page and Navigate to Cart Page
      When user clicks on Continue Shopping button
      Then user is navigated to the homepage

    Scenario: User Go back to Checkout
      Given user opens a browser and navigates to the e-commerce site
      When user adds product from the Home Page and Navigate to Cart Page
      When user clicks on Checkout button
      Then user is navigated to the checkout