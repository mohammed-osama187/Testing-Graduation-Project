@CouponAndGift
  Feature: User can use Coupons and Gifts

    Scenario: User Enters Invalid Coupon
      Given user opened the browser and navigates to the e-commerce site
      When the user adds a product from the Home Page and Navigates to the Cart Page
      And the user open coupon section, enters "INVALID" and click on Apply Coupon Button
      Then Error message should appear to the user

    Scenario: User Enters Empty Coupon
      Given user opened the browser and navigates to the e-commerce site
      When the user adds a product from the Home Page and Navigates to the Cart Page
      And the user open coupon section, enters "" and click on Apply Coupon Button
      Then Warning message should appear to the user

    Scenario: User Enters Invalid Gift
      Given user opened the browser and navigates to the e-commerce site
      When the user adds a product from the Home Page and Navigates to the Cart Page
      And the user open gift section, enters "INVALID" and click on Apply Coupon Button
      Then Error message should appear to user

    Scenario: User Enters Empty Gift
      Given user opened the browser and navigates to the e-commerce site
      When the user adds a product from the Home Page and Navigates to the Cart Page
      And the user open gift section, enters "" and click on Apply Coupon Button
      Then Warning message should appear to user