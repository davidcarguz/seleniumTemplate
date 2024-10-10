package core;

import org.openqa.selenium.WebDriver;
import pages.ResultsPage;
import pages.SearchPage;

public class Context extends DriverBuilder{

    private SearchPage searchPage;
    private ResultsPage resultsPage;

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

    /**
     * Creates an instance of SearchPage or returns one if already exists.
     * @return instance of searchPage.
     */
    public SearchPage getTestPage()
    {
        if(searchPage == null)
        {
            searchPage = new SearchPage(driver);
        }
        return searchPage;
    }

    /**
     * Creates an instance of resultsPage or returns one if already exists.
     * @return instance of resultsPage.
     */
    public ResultsPage getResultsPage() {
        if( resultsPage == null ) {
            resultsPage = new ResultsPage(driver);
        } else {
            return resultsPage;
        }
        return resultsPage;
    }
}
