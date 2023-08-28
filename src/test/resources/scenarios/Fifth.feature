@UI @smoke
Feature: Example UI scenario

  Background:Sets the base url and opens the login page
    Given the user sets the base url to "https://www.saucedemo.com"
    And the user opens the "/" url


  Scenario:Logs in with correct credentials
    Given the user types in the "standard_user" to the "username" field on the "login" page
    And the user types in the "secret_sauce" to the "password" field on the "login" page
    When the user presses the "login" button on the "login" page