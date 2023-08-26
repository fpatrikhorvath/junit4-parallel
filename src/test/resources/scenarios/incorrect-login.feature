@UI @smoke
Feature:TODO

  Scenario:TODO
    Given the user opens the "https://www.saucedemo.com/" url
    And the user types in the "standard_user" to the username field
    And the user types in the "incorrect-password" to the password field
    When the user presses the "login" button (on the login page)
    Then the user is navigated to the login page
