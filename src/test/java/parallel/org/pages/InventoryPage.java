package parallel.org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class represents the Inventory page of the application and provides methods to interact with its elements.
 */
public class InventoryPage extends BasePage {

    /**
     * Constructor to initialize the InventoryPage instance with the WebDriver.
     *
     * @param driver The WebDriver instance associated with the current thread.
     */
    public InventoryPage(ThreadLocal<WebDriver> driver) {
        super(driver);
    }

    /**
     * WebElement representing the inventory container on the page.
     */
    @FindBy(id = "inventory_container")
    WebElement inventoryContainer;

    /**
     * Checks if the InventoryPage is initialized and visible.
     *
     * @return True if the inventory container element is visible, indicating the page is initialized.
     */
    @Override
    public boolean isInitialized() {
        return isElementVisible(inventoryContainer);
    }
    /**
     * Clicks on the specified element on the Login page.
     *
     * @param element The element to click on (e.g. button).
     */
    public void clickOnElement(String element) {
        switch (element) {
            //case "login":
            //    clickOnElement(loginButton);
            //    break;
            default:
                throw new IllegalArgumentException("Element to click does not exists!");
        }
    }
}
