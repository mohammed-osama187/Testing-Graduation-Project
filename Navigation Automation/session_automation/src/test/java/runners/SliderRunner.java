package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/Slider.feature",
        glue = {"stepDefinitions"},
        tags = "@Slider"
)
public class SliderRunner extends AbstractTestNGCucumberTests {
}