package org.example;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/Search.feature",
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class SearchRunner extends AbstractTestNGCucumberTests {
}