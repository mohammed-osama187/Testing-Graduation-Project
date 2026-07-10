package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        tags = "@EstimateShipping",
        plugin = {"pretty", "html:target/EstimateShipping-report.html"}
)


public class EstimateShippingRunner extends AbstractTestNGCucumberTests {
}
