package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/GlobalNavigation.feature",
        glue = {"stepDefinitions"},
        tags = "@GlobalNav",
        plugin = {"pretty", "html:target/GlobalNav-report.html"}
)
public class GlobalNavRunner extends AbstractTestNGCucumberTests {
}