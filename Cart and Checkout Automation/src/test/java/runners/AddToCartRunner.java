package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        tags = "@AddToCart",
        plugin = {"pretty", "html:target/AddToCart-report.html"}
)

public class AddToCartRunner extends AbstractTestNGCucumberTests {
}