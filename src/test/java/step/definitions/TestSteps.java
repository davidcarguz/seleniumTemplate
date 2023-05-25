package step.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static com.google.common.truth.Truth.assertThat;
import pages.TestPage;

public final class TestSteps {

    /**
     * testPage holds ui interactions logic.
     */
    private TestPage testPage;
    /**
     * TestSteps constructor method.
     */
    public TestSteps() {
        testPage = new TestPage();
    }

    /**
     * Step that searches for a word.
     * @param searchWord to be searched
     */
    @When("I search for {string}")
    public void iSearchFor(final String searchWord) {
        testPage.seachForAWord(searchWord).clickSearchButton();
    }

    /**
     * Step that asserts for sideTitle text.
     * @param searchedWord expected word
     */
    @Then("I see results include the word {string}")
    public void iSeeResultsIncludeTheWord(final String searchedWord) {
        String obtainedWord = testPage.getSideTitleText();
        assertThat(obtainedWord).matches(searchedWord);
    }

    /**
     * Step that open the store from demoblaze page
     * @param store,site of the page
     */
    @Given("I open {string} from {string} page")
    public void iOpenDemoblaze(final String store, final String site) {
        testPage.openDemoblaze(store,site);
        testPage.selectStorePage();
    }

    /**
     * Step that enter username and password.
     * @param username,password credentials
     */
    @When("I enter username {string} and password {string}")
    public void iEnterUsernamePassword(final String username, final String password) {
        testPage.enterCredentials(username,password).clickLoginButton();
    }

    /**
     * Step that asserts that the user is already logged in
     */
    @Then("I see the user is logged in")
    public void iSeeUserIsLoggedIn() {
        String obtainedUserLoggedIn = testPage.getUserText();
        assertThat(obtainedUserLoggedIn).matches("Welcome testingSelenium@gmail.com");
    }

}
