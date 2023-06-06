package core;

import org.openqa.selenium.WebDriver;
import utils.DriverUtils;

public class Driver {

    /**
     * WebDriver variable to execute test over the browser.
     */
    private static WebDriver driver;

    /**
     * retrieves an WebDriver instance.
     * @return WebDriver instance.
     */
    public WebDriver getDriver() {
        if (driver == null) {
            driver = DriverUtils.initDriver(System.getProperty("BROWSER"),
                    System.getProperty("CI"));
        }
        return driver;
    }
}
