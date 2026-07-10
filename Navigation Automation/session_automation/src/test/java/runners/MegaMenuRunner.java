package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/MegaMenu.feature",
        glue = {"stepDefinitions"},
        tags = "@MegaMenu"
)
public class MegaMenuRunner extends AbstractTestNGCucumberTests {
}