package step.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

import static com.google.common.truth.Truth.assertThat;

public final class LoginSteps {

    /**
     * testPage holds ui interactions logic.
     */
    private LoginPage loginPage;
    /**
     * TestSteps constructor method.
     */
    public LoginSteps() {
        loginPage = new LoginPage();
    }

    /**
     * Step that open the store from demoblaze page
     * @param store,site of the page
     */
    @Given("I open {string} from {string} page")
    public void iOpenDemoblaze(final String store, final String site) {
        loginPage.openDemoblaze(store,site);
        loginPage.selectStorePage();
    }

    /**
     * Step that enter username and password.
     * @param username,password credentials
     */
    @When("I enter username {string} and password {string}")
    public void iEnterUsernamePassword(final String username, final String password) {
        loginPage.enterCredentials(username,password).clickLoginButton();
    }

    /**
     * Step that asserts that the user is already logged in
     */
    @Then("I see the user is logged in")
    public void iSeeUserIsLoggedIn() {
        String obtainedUserLoggedIn = loginPage.getUserText();
        assertThat(obtainedUserLoggedIn).matches("Welcome testingSelenium@gmail.com");
    }

    @Then("I see an alert with the message {string}")
    public void iSeeAnAlertWithTheMessage(final String message) {
        String alertMessage = loginPage.getAlertText();
        assertThat(alertMessage).matches(message);
        loginPage.acceptAlert();
    }
}
