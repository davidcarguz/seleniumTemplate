package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DriverManager {
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

    /**
     * Implements page factory in specified page.
     * @param driver instance.
     * @param page page instance.
     */
    public void initiatePage(final WebDriver driver, final Object page) {
        PageFactory.initElements(driver, page);
    }

}
