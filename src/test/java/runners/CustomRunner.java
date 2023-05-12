package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = { "step.definitions" },
        features = { "src/test/resources/features/" },
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class CustomRunner extends AbstractTestNGCucumberTests {
}
