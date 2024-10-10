package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import core.DriverManager;
import utils.Constants;

import java.time.Duration;

public class ResultsPage {

    /**
     * WebDriverWait variable.
     */
    private final WebDriverWait wait;

    /**
     * Title in left side.
     */
    @FindBy(xpath = "//div[@data-attrid='title']")
    private WebElement title;

    public ResultsPage(final WebDriver driver) {
        DriverManager driverManager = new DriverManager();
        driverManager.initiatePage(driver, this);
        int waitTime = Constants.WAIT_TIME_IN_SECONDS;
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
    }

    /**
     * Gets the side title text.
     * @return String side title text
     */
    public String getSideTitleText() {
        wait.until(ExpectedConditions.visibilityOf(title));
        return title.getText();
    }
}
