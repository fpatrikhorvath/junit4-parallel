@API @smoke
Feature:TODO

  Background:TODO
    Given I set the "https://the-internet.herokuapp.com" as URI and the "/status_codes" as path

  Scenario:TODO
    When I send a GET request to the "/404" endpoint
    Then I get 404 as response code