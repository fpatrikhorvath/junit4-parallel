package parallel.org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public abstract class BasePage {
    protected static final Logger logger = LogManager.getLogger(BasePage.class);

    /**
     * The {@code ThreadLocal} instance of the WebDriver associated with this page.
     */
    protected ThreadLocal<WebDriver> driver;

    /**
     * Schema for the children objects for the provided WebDriver instance.
     *
     * @param driver The {@code ThreadLocal<WebDriver>} instance representing the WebDriver.
     */
    public BasePage(ThreadLocal<WebDriver> driver) {
        logger.info("Initializing the driver and the page factory");
        this.driver = driver;
        PageFactory.initElements(driver.get(), this);
    }

    /**
     * Enters the specified text into the given web element.
     *
     * @param element The web element to which the text will be entered.
     * @param text    The text to be entered into the web element.
     */
    protected void enterTextToElement(WebElement element, String text) {
        element.sendKeys(text);
    }

    /**
     * Clicks on the provided web element.
     *
     * @param element The web element to be clicked.
     */
    protected void clickOnElement(WebElement element) {
        element.click();
    }

    /**
     * Checks whether the provided web element is currently visible on the page.
     *
     * @param element The web element to be checked for visibility.
     * @return true if the element is visible, false otherwise.
     */
    protected boolean isElementVisible(WebElement element) {
        return element.isDisplayed();
    }

    /**
     * This method should be overridden in each subclass to determine whether
     * the page has been successfully initialized.
     *
     * @return true if the page is correctly initialized,  false otherwise.
     */
    protected abstract boolean isInitialized();
}