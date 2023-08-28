@API @smoke
Feature: Example Api Scenario

  Background:Sets the base uri and path
    Given I set the "https://the-internet.herokuapp.com" as URI and the "/status_codes" as path

  Scenario:Sends a GET request to the /200 endpoint
    When I send a GET request to the "/200" endpoint
    Then I get 200 as response code