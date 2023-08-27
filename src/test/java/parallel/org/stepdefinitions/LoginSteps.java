package parallel.org.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import parallel.org.Utils;

import static org.junit.Assert.assertTrue;
import static parallel.org.stepdefinitions.Hooks.*;

public class LoginSteps {
    @Given("the user opens the {string} url")
    public void the_user_is_on_the_page(String url) {
        driverThreadLocal.get().navigate().to(Utils.BASE_URI +url);
    }

    @And("the user types in the {string} to the username field")
    public void theUserTypesInTheToTheUsername(String username) {
        loginPageThreadLocal.get().enterTextToElement("username", username);
    }

    @And("the user types in the {string} to the password field")
    public void theUserTypesInTheToThePassword(String password) {
        loginPageThreadLocal.get().enterTextToElement("password", password);
    }

    @When("the user presses the {string} button \\(on the login page)")
    public void theUserPressesTheButtonOnTheLoginPage(String button) {
        loginPageThreadLocal.get().clickOnElement(button);
    }

    @Then("the user is navigated to the login page")
    public void theUserIsNavigatedToTheLoginPage() {
        String message = "";//TODO
        boolean initState = loginPageThreadLocal.get().isInitialized();
        assertTrue(message, initState);
    }
}
