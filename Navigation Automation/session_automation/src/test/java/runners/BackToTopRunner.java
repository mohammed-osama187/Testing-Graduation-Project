package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/BackToTop.feature",
        glue = {"stepDefinitions"}
)
public class BackToTopRunner extends AbstractTestNGCucumberTests {
}