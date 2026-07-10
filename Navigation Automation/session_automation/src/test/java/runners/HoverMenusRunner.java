package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/HoverAndDropdowns.feature",
        glue = {"stepDefinitions"},
        tags = "@HoverMenu",
        plugin = {"pretty", "html:target/HoverMenus-report.html"}
)
public class HoverMenusRunner extends AbstractTestNGCucumberTests {
}