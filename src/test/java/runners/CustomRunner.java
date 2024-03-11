package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        glue = { "step.definitions" },
        features = { "src/test/resources/features/" },
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class CustomRunner extends AbstractTestNGCucumberTests {
    /**
     * Allows to execute scenarios in parallel.
     * @return array os scenarios.
     */
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
