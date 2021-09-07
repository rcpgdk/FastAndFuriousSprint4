package com.FastAndFurious4.runners;







import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports"},
        features = "src/test/resources/features",
        glue = "com/FastAndFurious4/Stepdefinitions",
            dryRun = false,
        tags="@"
)




public class CukesRunner {
}
