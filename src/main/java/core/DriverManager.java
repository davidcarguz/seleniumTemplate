package core;

import org.openqa.selenium.WebDriver;
import utils.Browser;
import utils.DriverUtils;

public class DriverManager {

    private WebDriver driver;

    public void initiateDriver() {
        this.driver = DriverUtils.initDriver(Browser.CHROME);
        this.driver.manage().window().maximize();
        this.driver.get("https://www.wizeline.com/");
    }

    public void terminateDriver() {
        this.driver.quit();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

}
