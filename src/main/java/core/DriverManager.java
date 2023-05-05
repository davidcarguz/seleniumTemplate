package core;

import org.openqa.selenium.WebDriver;
import utils.Browser;
import utils.DriverUtils;

public class DriverManager {

    /**
     * WebDriver variable to execute test over the browser.
     */
    private WebDriver driver;

    /**
     * creates a WebDriver instance and configures it.
     */
    public void initiateDriver() {
        this.driver = DriverUtils.initDriver(Browser.CHROME);
        this.driver.manage().window().maximize();
        this.driver.get("https://www.wizeline.com/");
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
