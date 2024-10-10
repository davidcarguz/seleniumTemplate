package step.definitions;

import core.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static com.google.common.truth.Truth.assertThat;

import pages.ResultsPage;
import pages.SearchPage;

public final class TestSteps {

    /**
     * testPage holds ui interactions logic.
     */
    private final SearchPage searchPage;
    private final ResultsPage resultsPage;
    /**
     * TestSteps constructor method.
     * @param context instance.
     */
    public TestSteps(final Context context) {
        this.searchPage = context.getTestPage();
        this.resultsPage = context.getResultsPage();
    }

    /**
     * Step that searches for a word.
     * @param searchWord to be searched
     */
    @When("I search for {string}")
    public void iSearchFor(final String searchWord) {
        searchPage.dismissGooglePopUp();
        searchPage.searchForAWord(searchWord).clickSearchResultRecord(searchWord);
    }

    /**
     * Step that asserts for sideTitle text.
     * @param searchedWord expected word
     */
    @Then("I see results include the word {string}")
    public void iSeeResultsIncludeTheWord(final String searchedWord) {
        String obtainedWord = resultsPage.getSideTitleText();
        assertThat(obtainedWord).matches(searchedWord);
    }

}
