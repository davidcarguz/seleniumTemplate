package pages;

import core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestPage {
    /**
     * Driver instance.
     */
    private final WebDriver driverInstance;
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
    @FindBy(xpath = "//span[@role = 'heading' and  @class = 'yKMVIe']")
    private WebElement sideTitle;
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
        wait.until(ExpectedConditions.visibilityOf(sideTitle));
        return sideTitle.getText();
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
}
