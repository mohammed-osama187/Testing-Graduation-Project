package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        tags = "@CouponAndGift",
        plugin = {"pretty", "html:target/CouponAndGifts-report.html"}
)

public class CouponAndGiftRunner extends AbstractTestNGCucumberTests {
}
