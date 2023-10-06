package parallel.org.stepdefinitions;

import io.cucumber.java.en.Given;

/**
 * This class provides step definitions related to the inventory page of the application.
 */
public class InventorySteps extends BaseUtil {
    BaseUtil base;

    public InventorySteps(BaseUtil base) {
        this.base = base;
    }

    @Given("the user opens the {string} url")
    public void the_user_opens_the_url(String endpoint) {
        base.driver.navigate().to(base.baseUrl + endpoint);
    }
}
