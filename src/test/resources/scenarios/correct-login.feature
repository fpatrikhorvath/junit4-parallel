@UI @smoke
Feature:TODO
  Background:TODO
    Given the user sets the base url to "https://www.saucedemo.com"

  Scenario:TODO
    Given the user opens the "/" url
    And the user types in the "standard_user" to the username field
    And the user types in the "secret_sauce" to the password field
    When the user presses the "login" button (on the login page)
    Then the user is navigated to the inventory page
