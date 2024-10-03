package core;

import org.openqa.selenium.WebDriver;
import pages.TestPage;

public class Context extends DriverBuilder{

    private TestPage testPage;

    public Context() {
        setup();
    }
    /**
     * retrieves an WebDriver instance.
     * @return WebDriver instance.
     */
    public WebDriver getDriver() {
        return this.driver;
    }

    public TestPage getTestPage()
    {
        if(testPage==null)
        {
            testPage = new TestPage(driver);
        }
        return testPage;
    }
}
