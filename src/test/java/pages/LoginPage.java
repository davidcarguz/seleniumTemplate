package pages;

import core.Driver;
import core.DriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends Driver {

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
     * Site
     */
    @FindBy(xpath = "//h3[text()='STORE']")
    private WebElement storeSite;

    /**
     * Log In Button
     */
    @FindBy(id = "login2")
    private WebElement startLoginButton;

    /**
     * Username Text Field
     */
    @FindBy(id = "loginusername")
    private WebElement loginUsername;
    /**
     * Password Text Field
     */
    @FindBy(id = "loginpassword")
    private WebElement loginPassword;
    /**
     * Log In Button
     */
    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement loginButton;
    /**
     * User Logged In
     */
    @FindBy(id = "nameofuser")
    private WebElement nameOfUser;
    /**
     * Test page constructor.
     */
    public LoginPage() {
        DriverManager driverManager = new DriverManager();
        driver = getDriver();
        driverManager.initiatePage(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
    }

    /**
     * waits for search text area to be visible and inputs the word.
     * @param store,site to be searched
     * @return TestPage instance
     */
    public LoginPage openDemoblaze(final String store, final String site) {
        wait.until(ExpectedConditions.visibilityOf(searchTextArea));
        searchTextArea.sendKeys(site);
        searchTextArea.sendKeys(Keys.ENTER);
        return this;
    };

    /**
     * Clicks on search button after waiting for it to be clickable.
     */
    public void selectStorePage() {
        wait.until(ExpectedConditions.elementToBeClickable(storeSite));
        storeSite.click();
    }

    /**
     * waits for search text area to be visible and inputs the word.
     * @param username,password credentials
     * @return TestPage instance
     */
    public LoginPage enterCredentials(final String username, final String password) {
        wait.until(ExpectedConditions.visibilityOf(startLoginButton));
        startLoginButton.click();
        loginUsername.sendKeys(username);
        loginPassword.sendKeys(password);
        return this;
    };

    /**
     * Clicks on search button after waiting for it to be clickable.
     */
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    /**
     * Gets the side title text.
     * @return String side title text
     */
    public String getUserText() {
        wait.until(ExpectedConditions.visibilityOf(nameOfUser));
        return nameOfUser.getText();
    }

    public String getAlertText(){
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
}
