package parallel.org.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;
import static parallel.org.stepdefinitions.Hooks.*;

/**
 * This class provides step definitions related to the login functionality.
 */
public class LoginSteps {

    /**
     * And step: Types the provided username into the username field on the login page.
     *
     * @param username The username to be entered.
     */
    @And("the user types in the {string} to the username field")
    public void theUserTypesInTheToTheUsername(String username) {
        loginPageThreadLocal.get().enterTextToElement("username", username);
    }

    /**
     * And step: Types the provided password into the password field on the login page.
     *
     * @param password The password to be entered.
     */
    @And("the user types in the {string} to the password field")
    public void theUserTypesInTheToThePassword(String password) {
        loginPageThreadLocal.get().enterTextToElement("password", password);
    }

    /**
     * When step: Presses the specified button on the login page.
     *
     * @param button The name of the button to be pressed.
     */
    @When("the user presses the {string} button (on the login page)")
    public void theUserPressesTheButtonOnTheLoginPage(String button) {
        loginPageThreadLocal.get().clickOnElement(button);
    }

    /**
     * Then step: Verifies that the user is navigated to the login page.
     */
    @Then("the user is navigated to the login page")
    public void theUserIsNavigatedToTheLoginPage() {
        String message = "The login page is not appearing";
        boolean initState = loginPageThreadLocal.get().isInitialized();
        assertTrue(message, initState);
    }
}
