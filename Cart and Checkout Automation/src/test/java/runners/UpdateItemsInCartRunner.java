package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        tags = "@UpdateItemsInCart",
        plugin = {"pretty", "html:target/UpdateItemsInCart-report.html"}
)

public class UpdateItemsInCartRunner extends AbstractTestNGCucumberTests {
}
