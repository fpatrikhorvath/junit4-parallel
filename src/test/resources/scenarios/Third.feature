@API @smoke
Feature:Example API scenario

  Background:Sets the base uri and path
    Given I set the "https://the-internet.herokuapp.com" as URI and the "/status_codes" as path

  Scenario:Sends a GET request to the /404 endpoint
    When I send a GET request to the "/404" endpoint
    Then I get 404 as response code