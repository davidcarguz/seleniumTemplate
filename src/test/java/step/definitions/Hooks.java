package step.definitions;

import core.Driver;
import core.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import utils.DriverUtils;
import utils.PropertiesManager;

import java.io.ByteArrayInputStream;


public class Hooks extends Driver {

    /**
     * DriverManager instance which handles driver configuration.
     */
    private DriverManager driverManager;

    /**
     * WebDriver instance.
     */
    private WebDriver driver;

    /**
     * Instantiates the cucumber hooks.
     */
    public Hooks() {
        driverManager = new DriverManager();
    }

    /**
     * Before hook executes before each test executed.
     */
    @Before
    public void beforeHook() {
        PropertiesManager.setPropertiesFromFile();
        driver = getDriver();
        driverManager.setupDriver(driver);
    }

    /**
     * After hook executes after each test executed.
     * @param scenario metadata
     */
    @After
    public void afterHook(final Scenario scenario) {
        byte[] screenshot = DriverUtils.getScreenshotAsBytes(driver);
        Allure.addAttachment(scenario.getName(),
                new ByteArrayInputStream(screenshot));
        driverManager.terminateDriver(driver);
    }
}
