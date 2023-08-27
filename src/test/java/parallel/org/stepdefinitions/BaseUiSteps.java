package parallel.org.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;
import static parallel.org.stepdefinitions.Hooks.*;

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

    /**
     * When step: Presses the specified button on the given page.
     *
     * @param button The name of the button to be pressed.
     */
    @When("the user presses the {string} button on the {string} page")
    public void theUserPressesTheButtonOnTheLoginPage(String button, String page) {
        switch (page) {
            case "login":
                loginPageThreadLocal.get().clickOnElement(button);
                break;
            case "inventory":
                inventoryPageThreadLocal.get().clickOnElement(button);
                break;
            default:
                throw new IllegalArgumentException(page + " is not exists or not implemented yet!");
        }
    }

    /**
     * Given step: Verifies that the user is navigated to the given page.
     *
     * @param page is the page we are verifying.
     */
    @Given("the user is navigated to the {string} page")
    public void the_user_is_navigated_to_the_inventory_page(String page) {
        String message = "The user is not navigated to the inventory page";
        boolean initState;
        switch (page) {
            case "login":
                message = "The user is not on the login page";
                initState = loginPageThreadLocal.get().isInitialized();
                break;
            case "inventory":
                message = "The user is not on the inventory page";
                initState = inventoryPageThreadLocal.get().isInitialized();
                break;
            default:
                throw new IllegalArgumentException(page + " is not exists or not implemented yet!");
        }
        assertTrue(message, initState);
    }

    /**
     * And step: Types the provided input text into the given field on the given page.
     *
     * @param text  the text we are inserting
     * @param input the input field which we are interacting with
     * @param page  the page where are the inputs are located
     */
    @And("the user types in the {string} to the {string} field on the {string} page")
    public void theUserTypesInTheToTheUsername(String text, String input, String page) {
        switch (page) {
            case "login":
                loginPageThreadLocal.get().enterTextToElement(input, text);
                break;
            default:
                throw new IllegalArgumentException(page + " is not exists or not implemented yet!");
        }
    }
}
