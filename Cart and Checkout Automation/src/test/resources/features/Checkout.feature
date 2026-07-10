@Checkout
Feature: User Completes Checkout

  Background:
    Given the user is on the checkout page with items in the cart

  Scenario Outline: Successful Guest Checkout
    When the user selects guest checkout and fills guest details with "<firstName>", "<lastName>", "<email>", "<telephone>", "<company>", "<address1>", "<address2>", "<city>", "<postCode>", "<country>", and "<region>"
    And handles optional preferences and terms
    And clicks the continue button
    Then the order should proceed to the next step

    Examples:
      | firstName | lastName | email          | telephone  | company | address1    | address2 | city  | postCode | country | region |
      | John      | Doe      | john@test.com  | 1234567890 | Tech Co | 123 Main St | Apt 4B   | Cairo | 11511    | Egypt   | Al Qahirah  |

  Scenario Outline: Successful Register Checkout
    When the user selects register account checkout And fills registration details with "<firstName>", "<lastName>", "<email>", "<telephone>", "<password>", "<confirmPassword>", "<company>", "<address1>", "<address2>", "<city>", "<postCode>", "<country>", and "<region>"
    And handles optional preferences and terms
    And clicks the continue button
    Then the order should proceed to the next step

    Examples:
      | firstName | lastName | email   | telephone  | password | confirmPassword | company | address1   | address2 | city | postCode | country | region |
      | Jane      | Smith    | RANDOM  | 0987654321 | Pass123! | Pass123!        | Soft Co | 456 Oak Rd | Floor 2  | Giza | 12611    | Egypt   | Al Qahirah   |

  Scenario Outline: Successful Checkout with Different Shipping Address
    When the user selects guest checkout and fills guest details with "John", "Doe", "john@test.com", "1234567890", "Tech", "123 Main St", "", "Cairo", "11511", "Egypt", "Al Qahirah"
    And chooses to ship to a different address And fills alternative shipping details with "<shipFN>", "<shipLN>", "<shipCompany>", "<shipAdd1>", "<shipAdd2>", "<shipCity>", "<shipPostCode>", "<shipCountry>", and "<shipRegion>"
    And handles optional preferences and terms
    And clicks the continue button
    Then the order should proceed to the next step

    Examples:
      | shipFN | shipLN | shipCompany | shipAdd1      | shipAdd2 | shipCity   | shipPostCode | shipCountry | shipRegion |
      | Alex   | Jones  | Logistics   | 789 Desert Rd | Gate 2   | Alexandria | 21500        | Egypt       | Al Qahirah |


  Scenario: Successful Checkout with Comment
    When the user selects guest checkout and fills guest details with "John", "Doe", "john@test.com", "1234567890", "Tech", "123 Main St", "", "Cairo", "11511", "Egypt", "Al Qahirah"
    And inputs the comment "Please deliver after 5 PM"
    And handles optional preferences and terms
    And clicks the continue button
    Then the order should proceed to the next step

  Scenario Outline: Successful Login with Existing Billing Address
    When the user logs in with email "<email>" and password "<password>"
    And completes login checkout using existing billing address with telephone "<telephone>"
    And handles optional preferences and terms
    And clicks the continue button
    Then the order should proceed to the next step

    Examples:
      | email             | password    | telephone  |
      | motest@gmail.com  | 123456789   | 0100234567 |

  Scenario Outline: Successful Login with New Billing Address
    When the user logs in with email "<email>" and password "<password>"
    And completes login checkout with a new billing address using "<firstName>", "<lastName>", "<telephone>", "<company>", "<address1>", "<address2>", "<city>", "<postCode>", "<country>", and "<region>"
    And handles optional preferences and terms
    And clicks the continue button
    Then the order should proceed to the next step

    Examples:
      | email             | password  | firstName | lastName | telephone  | company   | address1       | address2 | city  | postCode | country | region      |
      | motest@gmail.com  | 123456789 | Mark      | Spencer  | 5556667777 | Retail Co | 101 Fashion St | Suite 10 | Cairo | 11511    | Egypt   | Al Qahirah  |


  Scenario Outline: Guest Checkout - Input Field Validation Failures
    When the user selects guest checkout And fills guest details with "<firstName>", "<lastName>", "<email>", "<telephone>", "Company", "<address1>", "", "<city>", "<postCode>", "Egypt", "Al Qahirah"
    And clicks the continue button
    Then The field "<fieldName>" should display the error message "<errorMessage>"

    Examples:
      | firstName | lastName | email             | telephone  | address1    | city  | postCode | fieldName | errorMessage                                   |
      |           | Doe      | test@test.com     | 1234567890 | 123 Main St | Cairo | 11511    | firstname | First Name must be between 1 and 32 characters!|
      | John      |          | test@test.com     | 1234567890 | 123 Main St | Cairo | 11511    | lastname  | Last Name must be between 1 and 32 characters! |
      | John      | Doe      | plainaddress      | 1234567890 | 123 Main St | Cairo | 11511    | email     | E-Mail address does not appear to be valid!    |
      | John      | Doe      | test@test.com     |            | 123 Main St | Cairo | 11511    | telephone | Telephone must be between 3 and 32 characters! |
      | John      | Doe      | test@test.com     | 1234567890 |             | Cairo | 11511    | address-1 | Address 1 must be between 3 and 128 characters!|
      | John      | Doe      | test@test.com     | 1234567890 | 123 Main St |       | 11511    | city      | City must be between 2 and 128 characters!     |

  Scenario Outline: Register Checkout - Password Validation Failures
    When the user selects register account checkout And fills registration details with "Jane", "Smith", "j@test.com", "123", "<password>", "<confirmPassword>", "Co", "St", "", "City", "123", "Egypt", "Al Qahirah"
    And clicks the continue button
    Then the field "<fieldName>" should display the error message "<errorMessage>"

    Examples:
      | password | confirmPassword | fieldName | errorMessage                                   |
      | Pass123! | WrongPass1!     | confirm   | Password confirmation does not match password! |
      | 123      | 123             | password  | Password must be between 4 and 20 characters!  |

  Scenario: User checkout without agreeing upon terms&Conditions
    When the user selects guest checkout and fills guest details with "John", "Doe", "john@test.com", "1234567890", "Tech", "123 Main St", "", "Cairo", "11511", "Egypt", "Al Qahirah"
    And clicks the continue button
    Then the error message "Warning: You must agree to the Terms & Conditions!" should appear

  Scenario Outline: Cart Management Edge Cases
    When the user selects guest checkout and fills guest details with "John", "Doe", "john@test.com", "1234567890", "Tech", "123 Main St", "", "Cairo", "11511", "Egypt", "Al Qahirah"
    And the user updates the product quantity to "<quantity>"
    And handles optional preferences and terms
    Then the system should react with "<expectedResult>"

    Examples:
      | quantity    | expectedResult                       |
      | 5           | User completes checkout successfully |
      | 99999999999 | User goes back to cart page          |
      | -1          | User goes back to cart page          |

  Scenario: Delete Item from Checkout Page
    When the user deletes the item from the checkout cart
    Then the checkout cart should reflect that the item is removed