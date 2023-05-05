package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = { "step.definitions" },
        features = { "src/test/resources/features/" }
)
public class CustomRunner extends AbstractTestNGCucumberTests {
}
