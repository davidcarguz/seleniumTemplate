package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.DriverUtils;
import utils.PropertiesManager;

public class DriverBuilder {

    /**
     * WebDriver variable to execute test over the browser.
     */
    protected WebDriver driver;
    /**
     * Initializes driver in constructor.
     */
    public void setup() {
        PropertiesManager.setPropertiesFromFile();
        if(this.driver == null) {
            this.driver = DriverUtils.initDriver(System.getProperty("BROWSER"),
                    System.getProperty("CI"));
        }
    }

    /**
     * Creates basic driver configuration.
     * @param driver instance.
     */
    public void setupDriver(final WebDriver driver) {
        driver.manage().window().maximize();
        driver.get(System.getProperty("URL"));
    }

    /**
     * closes all windows.
     * @param driver driver instance.
     */
    public void terminateDriver(final WebDriver driver) {
        driver.quit();
    }

}
