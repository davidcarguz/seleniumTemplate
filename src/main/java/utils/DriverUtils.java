package utils;

import io.github.bonigarcia.wdm.BrowserManager;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverUtils {

    public static WebDriver initDriver(Browser browser) {
        WebDriver driver;
        switch (browser) {
            case CHROME:
                ChromeDriverManager.getInstance().version("113.0").setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                FirefoxDriverManager.getInstance();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                EdgeDriverManager.getInstance();
                driver = new EdgeDriver();
                break;
            default:
                throw new Error("Driver not supported");
        }
        return driver;
    };
};
