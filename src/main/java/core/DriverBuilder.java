package core;

import org.openqa.selenium.WebDriver;
import utils.DriverUtils;
import utils.PropertiesManager;

public class DriverBuilder {

    /**
     * WebDriver variable to execute test over the browser.
     */
    private final WebDriver driver;
    /**
     * Initializes driver in constructor.
     */
    public DriverBuilder() {
        PropertiesManager.setPropertiesFromFile();
        this.driver = DriverUtils.initDriver(System.getProperty("BROWSER"),
                System.getProperty("CI"));
    }

    /**
     * retrieves an WebDriver instance.
     * @return WebDriver instance.
     */
    public WebDriver getDriver() {
        return this.driver;
    }
}
