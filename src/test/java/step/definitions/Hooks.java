package step.definitions;

import core.Context;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import utils.DriverUtils;
import utils.PropertiesManager;

import java.io.ByteArrayInputStream;


public class Hooks {

    private final Context context;
    /**
     * WebDriver instance.
     */
    private final WebDriver driver;

    /**
     * Instantiates the cucumber hooks.
     * @param driverBuilder instance
     */
    public Hooks(final Context context) {
        this.context = context;
        this.driver = context.getDriver();
    }

    /**
     * Before hook executes before each test executed.
     */
    @Before
    public void beforeHook() {
        PropertiesManager.setPropertiesFromFile();
        context.setupDriver(this.driver);
    }

    /**
     * After hook executes after each test executed.
     * @param scenario metadata
     */
    @After
    public void afterHook(final Scenario scenario) {
        byte[] screenshot = DriverUtils.getScreenshotAsBytes(this.driver);
        Allure.addAttachment(scenario.getName(),
                new ByteArrayInputStream(screenshot));
        context.terminateDriver(this.driver);
    }
}
