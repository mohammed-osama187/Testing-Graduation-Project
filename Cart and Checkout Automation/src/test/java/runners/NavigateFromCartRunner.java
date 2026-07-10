package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        tags = "@NavigateFromCart",
        plugin = {"pretty", "html:target/NavigateFromCart-report.html"}
)

public class NavigateFromCartRunner extends AbstractTestNGCucumberTests {
}
