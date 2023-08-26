package parallel.org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(ThreadLocal<WebDriver> driver) {
        super(driver);
    }
    @FindBy(id = "user-name")
    WebElement usernameInputField;
    @FindBy(id = "password")
    WebElement passwordInputField;
    @FindBy(id = "login-button")
    WebElement loginButton;

    @Override
    public boolean isInitialized() {
        return isElementVisible(loginButton);
    }

    public void clickOnElement(String element){
        switch (element){
            case "login":
                clickOnElement(loginButton);
                break;
            default:
                //TODO
        }
    }
    public void enterTextToElement(String element, String text){
        switch (element){
            case "username":
                enterTextToElement(usernameInputField, text);
                break;
            case "password":
                enterTextToElement(passwordInputField, text);
                break;
            default:
                //TODO
        }
    }
}