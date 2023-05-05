package core;

import org.openqa.selenium.WebDriver;
import utils.DriverUtils;
import utils.PropertiesManager;

public class DriverManager {

    /**
     * WebDriver variable to execute test over the browser.
     */
    private WebDriver driver;

    /**
     * creates a WebDriver instance and configures it.
     */
    public void initiateDriver() {
        PropertiesManager.setPropertiesFromFile();
        this.driver = DriverUtils.initDriver(System.getProperty("BROWSER"));
        this.driver.manage().window().maximize();
        this.driver.get(System.getProperty("URL"));
    }

    /**
     * closes all windows.
     */
    public void terminateDriver() {
        this.driver.quit();
    }

    /**
     * Makes available WebDriver instance.
     * @return {WebDriver} driver instance.
     */
    public WebDriver getDriver() {
        return this.driver;
    }

}
