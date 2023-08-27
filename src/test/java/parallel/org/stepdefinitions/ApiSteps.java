package parallel.org.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static parallel.org.stepdefinitions.Hooks.responseThreadLocal;
import static parallel.org.stepdefinitions.Hooks.restAssuredExtensionThreadLocal;

/**
 * This class provides step definitions for testing API-related scenarios using RestAssured.
 */
public class ApiSteps {

    /**
     * Given step: Sets the base URI and path for the API request.
     *
     * @param baseUri  The base URI to set.
     * @param basePath The base path to set.
     */
    @Given("I set the {string} as URI and the {string} as path")
    public void iSetTheAsURIAndTheAsPath(String baseUri, String basePath) {
        restAssuredExtensionThreadLocal.get().setUriAndPath(baseUri, basePath);
    }

    /**
     * When step: Sends a GET request to the specified API endpoint.
     *
     * @param endpoint The API endpoint to send the request to.
     */
    @When("I send a GET request to the {string} endpoint")
    public void iSendAGETRequestToTheEndpoint(String endpoint) {
        responseThreadLocal.set(restAssuredExtensionThreadLocal.get().getOps(endpoint));
    }

    /**
     * Then step: Verifies that the response status code matches the expected status code.
     *
     * @param expectedStatusCode The expected response status code.
     */
    @Then("I get {int} as response code")
    public void iGetAsResponseCode(int expectedStatusCode) {
        String message = "Response status code doesn't match the expected value.";
        assertEquals(message, expectedStatusCode, responseThreadLocal.get().getStatusCode());
    }
}
