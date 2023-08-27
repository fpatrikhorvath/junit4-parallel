package parallel.org.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * This class serves as the Cucumber test runner configuration.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/scenarios",
        plugin = {"pretty", "html:target/cucumber-report.html"},
        glue = "parallel.org.stepdefinitions"
)
public class TestRunner {}
