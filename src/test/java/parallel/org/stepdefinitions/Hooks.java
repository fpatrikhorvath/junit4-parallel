package parallel.org.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import parallel.org.extension.WebDriverExtension;
import parallel.org.pages.InventoryPage;
import parallel.org.pages.LoginPage;

public class Hooks {
    static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    static ThreadLocal<LoginPage> loginPageThreadLocal = new ThreadLocal<>();
    static ThreadLocal<InventoryPage> inventoryPageThreadLocal = new ThreadLocal<>();

    @Before("@UI")
    public void setUpUi(){
        WebDriverExtension webDriverExtension = new WebDriverExtension();
        driverThreadLocal = webDriverExtension.getDriverThreadLocal();
        loginPageThreadLocal.set(new LoginPage(driverThreadLocal));
        inventoryPageThreadLocal.set(new InventoryPage(driverThreadLocal));
    }
    @After("@UI")
    public void tearDown() {
        try {
            driverThreadLocal.get().quit();
        } finally {
            driverThreadLocal.remove();
        }
    }
}
