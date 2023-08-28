package parallel.org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class represents the Login page of the application and provides methods to interact with its elements.
 */
public class LoginPage extends BasePage {

    /**
     * Constructor to initialize the LoginPage instance with the WebDriver.
     *
     * @param driver The WebDriver instance associated with the current thread.
     */
    public LoginPage(ThreadLocal<WebDriver> driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    WebElement usernameInputField;
    @FindBy(id = "password")
    WebElement passwordInputField;
    @FindBy(id = "login-button")
    WebElement loginButton;

    /**
     * Checks if the LoginPage is initialized and visible.
     *
     * @return True if the login button element is visible, indicating the page is initialized.
     */
    @Override
    public boolean isInitialized() {
        logger.info("Checking the visibility state of the login page.");
        return isElementVisible(loginButton);
    }

    /**
     * Clicks on the specified element on the Login page.
     *
     * @param element The element to click on (e.g. button).
     */
    public void clickOnElement(String element) {
        logger.info("Performing a click on the " + element + " element.");
        switch (element) {
            case "login":
                clickOnElement(loginButton);
                break;
            default:
                throw new IllegalArgumentException("Element to click does not exists!");
        }
    }

    /**
     * Enters the specified text into the input element on the Login page.
     *
     * @param element The element to enter text into
     * @param text    The text to enter into the element.
     */
    public void enterTextToElement(String element, String text) {
        logger.info("Enter the following " + text + " text to the " + element + " element.");
        switch (element) {
            case "username":
                enterTextToElement(usernameInputField, text);
                break;
            case "password":
                enterTextToElement(passwordInputField, text);
                break;
            default:
                throw new IllegalArgumentException("Input field does not exists!");
        }
    }
}
