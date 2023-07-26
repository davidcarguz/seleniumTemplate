package step.definitions;

import core.DriverBuilder;
import core.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import utils.DriverUtils;
import utils.PropertiesManager;

import java.io.ByteArrayInputStream;


public class Hooks {
    /**
     * DriverManager instance which handles driver configuration.
     */
    private final DriverManager driverManager;

    /**
     * WebDriver instance.
     */
    private final WebDriver driver;

    /**
     * Instantiates the cucumber hooks.
     * @param driverBuilder instance
     */
    public Hooks(final DriverBuilder driverBuilder) {
        this.driver = driverBuilder.getDriver();
        driverManager = new DriverManager();
    }

    /**
     * Before hook executes before each test executed.
     */
    @Before
    public void beforeHook() {
        PropertiesManager.setPropertiesFromFile();
        driverManager.setupDriver(this.driver);
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
        driverManager.terminateDriver(this.driver);
    }
}
