@API @smoke
Feature: Example API scenario
  Expected to fail

  Background:Sets the base uri and path
    Given I set the "https://the-internet.herokuapp.com" as URI and the "/status_codes" as path

  Scenario: Send a GET request to the /200 endpoint
    When I send a GET request to the "/200" endpoint
    Then I get 404 as response code