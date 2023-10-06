package parallel.org.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


import static org.testng.AssertJUnit.assertTrue;

/**
 * This class provides step definitions for common UI-related actions that serve as building blocks
 * for Cucumber scenarios.
 */
public class BaseUiSteps extends BaseUtil {
    BaseUtil base;

    public BaseUiSteps(BaseUtil base) {
        this.base = base;
    }


    /**
     * Given step: Sets the base URL to be used for constructing URLs in subsequent steps.
     *
     * @param baseUrl The base URL to be set.
     */
    @Given("the user sets the base url to {string}")
    public void theUserSetsTheBasePathTo(String baseUrl) {
        base.baseUrl = baseUrl;
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
                base.loginPage.clickOnElement(button);
                break;
            case "inventory":
                base.inventoryPage.clickOnElement(button);
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
                initState = base.loginPage.isInitialized();
                break;
            case "inventory":
                message = "The user is not on the inventory page";
                initState = base.inventoryPage.isInitialized();
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
                base.loginPage.enterTextToElement(input, text);
                break;
            default:
                throw new IllegalArgumentException(page + " is not exists or not implemented yet!");
        }
    }

}
