package parallel.org.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import parallel.org.extension.RestAssuredExtension;
import parallel.org.extension.WebDriverExtension;
import parallel.org.pages.BasePage;
import parallel.org.pages.InventoryPage;
import parallel.org.pages.LoginPage;
import io.restassured.response.Response;

/**
 * This class contains Cucumber hooks for setting up and tearing down resources before and after scenarios.
 */
public class Hooks {
    private static final Logger logger = LogManager.getLogger(Hooks.class);

    static ThreadLocal<RestAssuredExtension> restAssuredExtensionThreadLocal = new ThreadLocal<>();
    static ThreadLocal<Response> responseThreadLocal = new ThreadLocal<>();
    static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    static ThreadLocal<String> uiBaseUriThreadLocal = new ThreadLocal<>();
    static ThreadLocal<LoginPage> loginPageThreadLocal = new ThreadLocal<>();
    static ThreadLocal<InventoryPage> inventoryPageThreadLocal = new ThreadLocal<>();

    /**
     * Before hook: Initializes the RestAssuredExtension for API testing.
     */
    @Before("@API")
    public void setUpApi(){
        restAssuredExtensionThreadLocal.set(new RestAssuredExtension());
    }

    /**
     * Before hook: Sets up the WebDriver, base URI, and initializes pages for UI testing.
     */
    @Before("@UI")
    public void setUpUi(){
        logger.info("Initializing the page objects.");
        WebDriverExtension webDriverExtension = new WebDriverExtension();
        uiBaseUriThreadLocal.set("");
        driverThreadLocal = webDriverExtension.getDriverThreadLocal();
        loginPageThreadLocal.set(new LoginPage(driverThreadLocal));
        inventoryPageThreadLocal.set(new InventoryPage(driverThreadLocal));
    }

    /**
     * After hook: Tears down the WebDriver instance after UI testing.
     */
    @After("@UI")
    public void tearDownUi(Scenario scenario) {
        logger.info("Tearing the selenium driver.");
        if(scenario.isFailed()){
            logger.info("Taking a screenshot about the issue.");
            final byte[] SCREENSHOT = ((TakesScreenshot) driverThreadLocal.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(SCREENSHOT, "image/png", "Screenshot.png");
        }
        try {
            driverThreadLocal.get().quit();
        } finally {
            driverThreadLocal.remove();
        }
    }
}
