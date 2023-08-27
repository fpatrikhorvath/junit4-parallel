package parallel.org.stepdefinitions;

import io.cucumber.java.en.Given;

import static org.junit.Assert.assertTrue;
import static parallel.org.stepdefinitions.Hooks.driverThreadLocal;
import static parallel.org.stepdefinitions.Hooks.inventoryPageThreadLocal;

/**
 * This class provides step definitions related to the inventory page of the application.
 */
public class InventorySteps {

    /**
     * Given step: Verifies that the user is navigated to the inventory page.
     */
    @Given("the user is navigated to the inventory page")
    public void the_user_is_navigated_to_the_inventory_page() {
        String message = "The user is not navigated to the inventory page";
        boolean initState = inventoryPageThreadLocal.get().isInitialized();
        assertTrue(message, initState);
    }
}
