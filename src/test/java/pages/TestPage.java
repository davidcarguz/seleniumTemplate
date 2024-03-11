package pages;

import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

import java.time.Duration;

public class TestPage {
    /**
     * Driver instance.
     */
    private final WebDriver driverInstance;

    /**
     * WebDriverWait variable.
     */
    private final WebDriverWait wait;

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
    @FindBy(xpath = "//div[@data-attrid='title']")
    private WebElement title;
    /**
     * Do not Access pop up Google button.
     */
    @FindBy(css = "button[data-dismiss='n']")
    private WebElement popUpDontAcceptButton;
    /**
     * google Iframe.
     */
    @FindBy(css = "iframe[role='presentation']")
    private WebElement googleIframe;
    /**
     * Test page constructor.
     * @param driver WebDriver instance.
     */
    public TestPage(final WebDriver driver) {
        DriverManager driverManager = new DriverManager();
        driverManager.initiatePage(driver, this);
        int waitTime = Constants.WAIT_TIME_IN_SECONDS;
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        this.driverInstance = driver;
    }

    /**
     * waits for search text area to be visible and inputs the word.
     * @param word to be searched
     * @return TestPage instance
     */
    public TestPage searchForAWord(final String word) {
        wait.until(ExpectedConditions.visibilityOf(searchTextArea));
        searchTextArea.sendKeys(word);
        return this;
    };

    /**
     * Clicks on search button after waiting for it to be clickable.
     */
    public void clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }

    /**
     * Gets the side title text.
     * @return String side title text
     */
    public String getSideTitleText() {
        wait.until(ExpectedConditions.visibilityOf(title));
        return title.getText();
    }

    /**
     * Closes the Google popup when is present.
     */
    public void dismissGooglePopUp() {
        try {
            this.driverInstance.switchTo().frame(googleIframe);
            popUpDontAcceptButton.click();
            this.driverInstance.switchTo().defaultContent();
        } catch (Exception e) {
            System.out.println("popup was not present");
        }
    }

    /**
     * Clicks on the record in search dropdown.
     * @param searchWord to be searched.
     */
    public void clickSearchResultRecord(final String searchWord) {
        final String locator = String.
                format("//li[@data-entityname='%s']", searchWord);
        WebElement resultRecord = wait.
                until(ExpectedConditions.
                        visibilityOfElementLocated(By.xpath(locator)
                        ));
        resultRecord.click();
    }
}
