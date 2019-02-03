package com.cybertek.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/homepage.feature",
        glue = "com/cybertek/step_definitions"
        , dryRun = true
        , tags = "@member, @teacher"
)
public class CukesRunner {
}
