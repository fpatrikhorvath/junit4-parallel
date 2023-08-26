package parallel.org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected ThreadLocal<WebDriver> driver;

    public BasePage(ThreadLocal<WebDriver> driver) {
        this.driver = driver;
        PageFactory.initElements(driver.get(), this);
    }

    protected void enterTextToElement(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected void clickOnElement(WebElement element) {
        element.click();
    }

    protected boolean isElementVisible(WebElement element) {
        return element.isDisplayed();
    }
    protected boolean isInitialized() {
        return false;
    }
}
