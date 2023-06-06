package utils;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public final class DriverUtils {

    private DriverUtils() { }

    /**
     * Dynamically instantiate a driver based on browser selection.
     * @param browser selection.
     * @return {WebDriver} driver instance.
     */
    public static WebDriver initDriver(final String browser) {
        WebDriver driver;
        switch (browser) {
            case "CHROME":
                ChromeDriverManager.getInstance().setup();
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                FirefoxDriverManager.getInstance().setup();
                driver = new FirefoxDriver();
                break;
            case "EDGE":
                EdgeDriverManager.getInstance().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new Error("Driver not supported");
        }
        return driver;
    }

    /**
     * Create a screenshot as an array of bytes.
     * @param driver instance
     * @return screenshot as an array of bytes
     */
    public static byte[] getScreenshotAsBytes(final WebDriver driver) {
        try {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            throw new Error(
                    "Something went wrong while taking the screenshot.", e);
        }
    }
}
