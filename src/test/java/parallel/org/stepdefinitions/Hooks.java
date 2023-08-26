package parallel.org.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import parallel.org.Utils;
import parallel.org.pages.InventoryPage;
import parallel.org.pages.LoginPage;

public class Hooks {
    static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    static ThreadLocal<LoginPage> loginPageThreadLocal = new ThreadLocal<>();
    static ThreadLocal<InventoryPage> inventoryPageThreadLocal = new ThreadLocal<>();

    @Before("@UI")
    public void setUpUi(){
        String driverPath = Utils.DRIVER_DIR + "/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driverThreadLocal.set(new ChromeDriver());
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
