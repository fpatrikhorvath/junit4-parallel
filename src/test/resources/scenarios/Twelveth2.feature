@UI @smoke
Feature: Example UI scenario4

  Background:Sets the base url
    Given the user sets the base url to "https://www.saucedemo.com"

  Scenario:Tries to login
    Given the user opens the "/" url
    And the user types in the "standard_user" to the "username" field on the "login" page
    And the user types in the "incorrect-password" to the "password" field on the "login" page
    When the user presses the "login" button on the "login" page
    Then the user is navigated to the "login" page
