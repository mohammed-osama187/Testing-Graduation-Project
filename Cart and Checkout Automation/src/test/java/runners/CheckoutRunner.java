package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        tags = "@Checkout",
        plugin = {"pretty", "html:target/Checkout-report.html"}
)

public class CheckoutRunner extends AbstractTestNGCucumberTests {
}
