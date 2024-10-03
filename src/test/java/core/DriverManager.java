package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DriverManager {
    /**
     * Implements page factory in specified page.
     * @param driver instance.
     * @param page page instance.
     */
    public void initiatePage(final WebDriver driver, final Object page) {
        PageFactory.initElements(driver, page);
    }
}
