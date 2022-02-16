package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import static manager.PageFactoryManager.LOREM_IPSUM_PAGE;

public class LoremIpsumSteps {

    @And("User opens {string} page")
    public void openPage(final String url) {
        //  loremIpsumPage = pageFactoryManager.getPart1Loremipsum();
        LOREM_IPSUM_PAGE.openPageSite(url);
    }

    @And("User click link Russian Language")
    public void userClickLinkRussianLanguage() {
        LOREM_IPSUM_PAGE.clickRussianLanguage();
    }


    @Then("Verify the text of the first  element, which is the first paragraph, contains the word {string}")
    public void verifyTheTextOfTheFirstElementWhichIsTheFirstParagraphContainsTheWordWord(final String keyword) {
        Assert.assertTrue(LOREM_IPSUM_PAGE.checkSearchWordOnPage(keyword));
    }

    @And("User press “Generate Lorem Ipsum”")
    public void userPressGenerateLoremIpsum() {
        LOREM_IPSUM_PAGE.clickPressButtonGenerate();
    }

    @Then("Verify that the first paragraph starts with word {string}")
    public void verifyThatTheFirstParagraphStartsWithWordWord(final String keyword) {
        Assert.assertTrue(LOREM_IPSUM_PAGE.checkSearchSecondWords(keyword));
    }

    @And("User click on label {string} word")
    public void userClickOnLabelWord(final String keyword) {
        LOREM_IPSUM_PAGE.clickLabelWords(keyword);
    }

    @And("User input meaning {string} field")
    public void userInputMeaningMeaningField(final String keyword) {
        LOREM_IPSUM_PAGE.inputMeaning(keyword);
    }

    @Then("Verify the result has meaning {string}")
    public void verifyTheResultHasMeaningMeaning(final String keyword) {
        LOREM_IPSUM_PAGE.checkGeneratedMeaning(keyword);
    }

    @And("User click on checkbox start")
    public void userClickOnCheckboxStart() {
        LOREM_IPSUM_PAGE.clickCheckBox();
    }

    @Then("Verify that result no longer starts with {string}Lorem ipsum")
    public void verifyThatResultNoLongerStartsWithLoremIpsumLoremIpsum(final String keyword) {
        LOREM_IPSUM_PAGE.resultCheckNotStartLoremIpsum(keyword);
    }

    @Then("Count the number of paragraphs containing the word - lorem")
    public void countTheNumberOfParagraphsContainingTheWordLorem() {
        LOREM_IPSUM_PAGE.countNumberOfParagraphWord();
    }

    @Then("Generate {int} times and count the average number of paragraphs containing the word - lorem and Checking the average")
    public void generateTimesAndCountTheAverageNumberOfParagraphsContainingTheWordLoremAndCheckingTheAverage(int arg0) {
        Assert.assertFalse(LOREM_IPSUM_PAGE.averageNumberOfParagraph() < 2);
    }


}



