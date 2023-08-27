package parallel.org.stepdefinitions;

import io.cucumber.java.en.Given;

import static parallel.org.stepdefinitions.Hooks.driverThreadLocal;
import static parallel.org.stepdefinitions.Hooks.uiBaseUriThreadLocal;

public class BaseUiSteps {
    @Given("the user opens the {string} url")
    public void the_user_is_on_the_page(String url) {
        driverThreadLocal.get().navigate().to(uiBaseUriThreadLocal.get() + url);
    }
    @Given("the user sets the base url to {string}")
    public void theUserSetsTheBasePathTo(String baseUrl) {
        uiBaseUriThreadLocal.set(baseUrl);
    }
}
