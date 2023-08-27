package parallel.org.stepdefinitions;

import io.cucumber.java.en.Given;

import static parallel.org.stepdefinitions.Hooks.driverThreadLocal;
import static parallel.org.stepdefinitions.Hooks.uiBaseUriThreadLocal;

/**
 * This class provides step definitions for common UI-related actions that serve as building blocks
 * for Cucumber scenarios.
 */
public class BaseUiSteps {

    /**
     * Given step: Opens the specified URL using the WebDriver instance associated with the current thread.
     *
     * @param url The relative URL to navigate to.
     */
    @Given("the user opens the {string} url")
    public void the_user_opens_the_url(String url) {
        driverThreadLocal.get().navigate().to(uiBaseUriThreadLocal.get() + url);
    }

    /**
     * Given step: Sets the base URL to be used for constructing URLs in subsequent steps.
     *
     * @param baseUrl The base URL to be set.
     */
    @Given("the user sets the base url to {string}")
    public void theUserSetsTheBasePathTo(String baseUrl) {
        uiBaseUriThreadLocal.set(baseUrl);
    }
}
