package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        tags = "@NavigateToCart",
        plugin = {"pretty", "html:target/Cart-report.html"}
)

public class CartTestsRunner extends AbstractTestNGCucumberTests {
}