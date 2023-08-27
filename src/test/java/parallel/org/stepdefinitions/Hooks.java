package parallel.org.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import parallel.org.extension.RestAssuredExtension;
import parallel.org.extension.WebDriverExtension;
import parallel.org.pages.InventoryPage;
import parallel.org.pages.LoginPage;
import io.restassured.response.Response;

public class Hooks {
    static ThreadLocal<RestAssuredExtension> restAssuredExtensionThreadLocal = new ThreadLocal<>();
    static ThreadLocal<Response> responseThreadLocal = new ThreadLocal<>();
    static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    static ThreadLocal<String> uiBaseUriThreadLocal = new ThreadLocal<>();//Selenium does not offer any way to change the base url
    static ThreadLocal<LoginPage> loginPageThreadLocal = new ThreadLocal<>();
    static ThreadLocal<InventoryPage> inventoryPageThreadLocal = new ThreadLocal<>();

    @Before("@API")
    public void setUpApi(){
        restAssuredExtensionThreadLocal.set(new RestAssuredExtension());
    }

    @Before("@UI")
    public void setUpUi(){
        WebDriverExtension webDriverExtension = new WebDriverExtension();
        uiBaseUriThreadLocal.set("");
        driverThreadLocal = webDriverExtension.getDriverThreadLocal();
        loginPageThreadLocal.set(new LoginPage(driverThreadLocal));
        inventoryPageThreadLocal.set(new InventoryPage(driverThreadLocal));
    }
    @After("@UI")
    public void tearDownUi() {
        try {
            driverThreadLocal.get().quit();
        } finally {
            driverThreadLocal.remove();
        }
    }
}
