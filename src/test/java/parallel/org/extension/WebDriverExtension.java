package parallel.org.extension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import parallel.org.Utils;

/**
 * This class provides an extension for managing WebDriver instances, specifically for ChromeDriver.
 */
public class WebDriverExtension {

    private final ThreadLocal<WebDriver> driverThreadLocal = ThreadLocal.withInitial(() -> {
        // Set the path to the ChromeDriver executable
        String driverPath = Utils.DRIVER_DIR + "/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        return setChromeDriver();
    });

    /**
     * Returns the ThreadLocal instance of WebDriver.
     *
     * @return The ThreadLocal instance of WebDriver.
     */
    public ThreadLocal<WebDriver> getDriverThreadLocal() {
        return driverThreadLocal;
    }

    /**
     * Sets up and configures a ChromeDriver instance with desired options.
     *
     * @return A new ChromeDriver instance.
     */
    public ChromeDriver setChromeDriver() {
        // Create ChromeOptions with desired configurations
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Example: Maximize the browser window
        //options.setHeadless(true);
        // Add more options as needed

        // Create and return a new ChromeDriver instance with ChromeOptions
        return new ChromeDriver(options);
    }
}
