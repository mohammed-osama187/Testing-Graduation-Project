@EstimateShipping
  Feature: Estimate Shipping Calculation

    Scenario Outline: Estimate shipping is applied successfully
      Given user opens browser and navigates to the e-commerce site
      When the user adds product from the Home Page and Navigate to Cart Page
      And the user opens estimate shipping section, choose "<country>" and "<state>" and "<postalcode>" , choose flat rate, and click apply
      Then flat rate shipping should be applied

      Examples:
      |country|state|postalcode|
      |Egypt|Al Qahirah||
      |United Kingdom|Aberdeen|123456|

    Scenario: Estimate shipping is canceled successfully
      Given user opens browser and navigates to the e-commerce site
      When the user adds product from the Home Page and Navigate to Cart Page
      And the user opens estimate shipping section, choose "Egypt" and "Al Qahirah" and "123456" , choose flat rate, and click cancel
      Then flat rate shipping should NOT be applied

      Scenario: Estimate shipping is NOT applied successfully (UK with empty PostCode)
        Given user opens browser and navigates to the e-commerce site
        When the user adds product from the Home Page and Navigate to Cart Page
        And the user opens estimate shipping section, choose "United Kingdom" and "Aberdeen" and ""
        Then Error message 'Postcode must be between 2 and 10 characters!' should appear

    Scenario: Estimate shipping is NOT applied successfully (empty Country and State)
      Given user opens browser and navigates to the e-commerce site
      When the user adds product from the Home Page and Navigate to Cart Page
      And the user opens estimate shipping section, choose " --- Please Select --- " and " --- Please Select --- " and ""
      Then Error message 'Please select a country!' should appear

    Scenario: Estimate shipping is NOT applied successfully (empty state)
      Given user opens browser and navigates to the e-commerce site
      When the user adds product from the Home Page and Navigate to Cart Page
      And the user opens estimate shipping section, choose "Egypt" and " --- Please Select --- " and ""
      Then Error message "Please select a region / state!" should appear to user