package step.definitions;

import core.Driver;
import core.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.PropertiesManager;


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
     */
    @After
    public void afterHook() {
        driverManager.terminateDriver(driver);
    }
}
