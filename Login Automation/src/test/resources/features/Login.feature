Feature: Login Functionality
  As a registered user of the LambdaTest E-Commerce Playground
  I want to log in using different combinations of email and password
  So that I can verify both successful login and proper error handling

  Background:
    Given the user is on the login page

  Scenario Outline: Attempt login with different credentials
    When the user attempts to login with email "<email>" and password "<password>"
    Then the login result should be "<expectedResult>"

    Examples:
      | email              | password       | expectedResult |
      | khaled@gmail.com   | 12345678       | success         |
      | khaled@gmail.com   | wrongpassword  | error           |
      | wrong@gmail.com    | 12345678       | error           |
      | wrong@gmail.com    | wrongpassword  | error           |
      |                    |                | error           |
      |                    | 12345678       | error           |
      | khaled@gmail.com   |                | error           |
      | !@#$%^&*()         | !@#$%^&*()     | error           |
