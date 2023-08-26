package parallel.org.stepdefinitions;

import io.cucumber.java.en.Given;

import static org.junit.Assert.assertTrue;
import static parallel.org.stepdefinitions.Hooks.driverThreadLocal;
import static parallel.org.stepdefinitions.Hooks.inventoryPageThreadLocal;

public class InventorySteps {
    @Given("the user is navigated to the inventory page")
    public void the_user_is_on_the_page() {
        String message= "";//TODO
        boolean initState = inventoryPageThreadLocal.get().isInitialized();
        assertTrue(message, initState);
    }
}
