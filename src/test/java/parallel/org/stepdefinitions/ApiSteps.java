package parallel.org.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static parallel.org.stepdefinitions.Hooks.responseThreadLocal;
import static parallel.org.stepdefinitions.Hooks.restAssuredExtensionThreadLocal;

public class ApiSteps {
    @Given("I set the {string} as URI and the {string} as path")
    public void iSetTheAsURIAndTheAsPath(String baseUri, String basePath) {
        restAssuredExtensionThreadLocal.get().setUriAndPath(baseUri, basePath);
    }

    @When("I send a GET request to the {string} endpoint")
    public void iSendAGETRequestToTheEndpoint(String endpoint) {
        responseThreadLocal.set(restAssuredExtensionThreadLocal.get().getOps(endpoint));
    }

    @Then("I get {int} as response code")
    public void iGetAsResponseCode(int expectedStatusCode) {
        String message = "";//TODO
        assertEquals(message, expectedStatusCode, responseThreadLocal.get().getStatusCode());
    }
}
