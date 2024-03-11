package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Objects;


public final class DriverUtils {

    private DriverUtils() { }

    /**
     * Dynamically instantiate a driver based on browser selection.
     * @param browser selection.
     * @param headless for ci runs.
     * @return {WebDriver} driver instance.
     */
    public static WebDriver initDriver(final String browser,
                                       final String headless) {
        WebDriver driver;
        switch (browser) {
            case "CHROME":
                ChromeOptions chromeOptions = new ChromeOptions();
                System.out.println("AQUI ESTOYYYY");
                if (Objects.equals(headless, "true")) {
                    chromeOptions.addArguments("--headless=new");
                }
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
                break;
            case "FIREFOX":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (Objects.equals(headless, "true")) {
                    firefoxOptions.addArguments("--headless");
                }
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "EDGE":
                EdgeOptions edgeOptions = new EdgeOptions();
                if (Objects.equals(headless, "true")) {
                    edgeOptions.addArguments("--headless");
                }
                WebDriverManager.edgedriver().setup();
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
