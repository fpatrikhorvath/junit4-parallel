package parallel.org.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.picocontainer.PicoContainer;
import parallel.org.pages.InventoryPage;
import parallel.org.pages.LoginPage;

/**
 * This class contains Cucumber hooks for setting up and tearing down resources before and after scenarios.
 */
public class Hook extends BaseUtil {
    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        base.driver = new ChromeDriver();
        base.loginPage = new LoginPage(base.driver);
        base.inventoryPage = new InventoryPage(base.driver);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] SCREENSHOT = ((TakesScreenshot) base.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(SCREENSHOT, "image/png", "Screenshot.png");
        }
        if (base.driver != null) {
            base.driver.close();
            base.driver.quit();
        }
    }
}
