package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import static manager.PageFactoryManager.BBC_1_PAGE;
import static manager.PageFactoryManager.BBC_QUESTION;

public class Bbc1TaskSteps {

    @Given("User opens {string} BBC")
    public void userOpensHomePageBBC(final String keyword) {
        BBC_1_PAGE.openHomePage(keyword);
        BBC_1_PAGE.waitForPageLoadComplete(60);
    }

    @Then("User click button {string} navigation bar")
    public void userClickButtonButtonNavigationBar(final String keyword) {
        BBC_1_PAGE.clickOnNavigationButtons(keyword);
    }

    @Then("Checks the name of the headline article in condition {string}")
    public void checksTheNameOfTheHeadlineArticleInConditionCondition(final String keyword) {
        Assert.assertTrue(BBC_1_PAGE.checkTopHeading(keyword));
    }

    @And("Checks secondary article titles")
    public void checksSecondaryArticleTitles() {
        String titles[] = {
                "N Korea funding missile projects with stolen crypto",
                "India bids farewell to iconic singer Lata Mangeshkar",
                "Tragic end for boy trapped in Moroccan well",
                "The fast fashion graveyard in a desert",
                "Deal to avoid war in Ukraine within reach - Macron"
        };
        for (int i = 0; i <= titles.length - 1; i++) {
            Assert.assertTrue(BBC_1_PAGE.checkSecondHeading(titles[i]));
        }

    }


    @And("Stores the text of the Category link of the headline {string} article")
    public void storesTheTextOfTheCategoryLinkOfTheHeadlineHeadLineArticle(final String keyword) {
        BBC_1_PAGE.storesLinkHeadLineNews(keyword);
    }

    @And("Enter this text in the Search bar")
    public void enterThisTextInTheSearchBar() {
        BBC_1_PAGE.enterTextSearchFiled();
    }


    @Then("Checking the name {string} of the first article against a specified value")
    public void checkingTheNameCheckNameArticleOfTheFirstArticleAgainstASpecifiedValue(final String keyword) {
        Assert.assertTrue(BBC_1_PAGE.checkFirstNameArticle(keyword));
    }

    @And("Click button subtitle {string}")
    public void clickButtonSubtitleSubtitle(final String keyword) {
        BBC_1_PAGE.clickButtonSubtitle(keyword);
    }

    @And("Click tab Your Coronavirus Stories")
    public void clickTabYourCoronavirusStories() {
        BBC_1_PAGE.clickButtonCoronavirusStories();
    }

    @And("Click link Your questions answered: What questions do you have?")
    public void clickLinkYourQuestionsAnsweredWhatQuestionsDoYouHave() {
        BBC_1_PAGE.clickLinkQuestion();
    }


    @And("Scrolling to form ask your question")
    public void scrollingToFormAskYourQuestion() {
        BBC_1_PAGE.scrollingToTextArea();
        BBC_1_PAGE.waitForPageLoadComplete(60);
        BBC_1_PAGE.clickClosePopUpWindow();
    }

    @And("Click button Submit")
    public void clickButtonSubmit() {BBC_QUESTION.clickButtonSubmit();
    }

    @Then("Checking the form submission for an error")
    public void checkingTheFormSubmissionForAnError() {
        Assert.assertTrue(BBC_QUESTION.checkSubmitToErrors());
    }

    @And("Input fields form question {string} and {string} and  {string} and {string} and {string} and {string}")
    public void inputFieldsFormQuestionQuestionAndNameAndEmailAndPhoneAndLocationAndAge( final String question, final String name, final String email, final String phone, final String location, final String age) {
        {
        BBC_QUESTION.fillingFormsWithData(question, name, email, phone, location, age);
    }
    }
}
