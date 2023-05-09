package step.definitions;

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

}
