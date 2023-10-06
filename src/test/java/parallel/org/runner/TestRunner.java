package parallel.org.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * This class serves as the Cucumber test runner configuration.
 */
@CucumberOptions(
        features = "src/test/resources/scenarios",
        plugin = {"pretty", "html:target/cucumber-report.html"},
        glue = "parallel.org.stepdefinitions"
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
