package parallel.org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage{
    public InventoryPage(ThreadLocal<WebDriver> driver) {
        super(driver);
    }
    @FindBy(id = "inventory_container")
    WebElement inventoryContainer;

    @Override
    public boolean isInitialized() {
        return isElementVisible(inventoryContainer);
    }
}
