package pages;

import core.Driver;
import core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestPage extends Driver {

    /**
     * WebDriver variable.
     */
    private final WebDriver driver;

    /**
     * Wait time in seconds.
     */
    private final int waitTime = 3;

    /**
     * WebDriverWait variable.
     */
    private WebDriverWait wait;

    /**
     * Search text area.
     */
    @FindBy(css = "textarea[class='gLFyf']")
    private WebElement searchTextArea;

    /**
     * Search button.
     */
    @FindBy(xpath = "(//input[@class='gNO89b'])[2]")
    private WebElement searchButton;
    /**
     * Title in left side.
     */
    @FindBy(css = "div[class='SPZz6b'] h2 span")
    private WebElement sideTitle;
    /**
     * Test page constructor.
     */
    public TestPage() {
        DriverManager driverManager = new DriverManager();
        driver = getDriver();
        driverManager.initiatePage(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
    }

    /**
     * waits for search text area to be visible and inputs the word.
     * @param word to be searched
     * @return TestPage instance
     */
    public TestPage seachForAWord(final String word) {
        wait.until(ExpectedConditions.visibilityOf(searchTextArea));
        searchTextArea.sendKeys(word);
        return this;
    };

    /**
     * Clicks on search button after waiting for it to be clickable.
     */
    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }

    /**
     * Gets the side title text.
     * @return String side title text
     */
    public String getSideTitleText() {
        wait.until(ExpectedConditions.visibilityOf(sideTitle));
        return sideTitle.getText();
    }

}
