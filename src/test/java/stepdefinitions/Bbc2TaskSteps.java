package stepdefinitions;
import io.cucumber.java.en.And;
import org.junit.Assert;

import static manager.PageFactoryManager.BBC_SPORT;
public class Bbc2TaskSteps {

    @And("Click button Scores and Fixtures")
    public void clickButtonScoresAndFixtures(){
        BBC_SPORT.clickButtonScoresFixtures();
    }

    @And("Click button Football")
    public void clickButtonFootball() {
        BBC_SPORT.clickButtonSectionFootball();
    }

    @And("Search for a championship {string}")
    public void searchForAChampionshipChampionship(final String keyword) {
        BBC_SPORT.searchChampionship(keyword);
    }

    @And("Select results for a day {string}")
    public void selectResultsForADayDay(final String keyword) {
        BBC_SPORT.clickDateChampionship(keyword);
    }

    @And("We determine that two teams {string} and {string} played with a score {string} : {string}")
    public void weDetermineThatTwoTeamsTeamAndTeamPlayedWithAScoreScoreTeamScoreTeam(final String team1, final String team2, final String scoreTeam1, final String scoreTeam2) {
        Assert.assertTrue(BBC_SPORT.checkSpecificScore(team1, team2, scoreTeam1, scoreTeam2));
    }

    @And("Click link {string}")
    public void clickLinkTeam(final String team1) {
        BBC_SPORT.clickLinkTeam(team1);
    }

    @And("Checking {string} and {string} names and scores {string} : {string} at the center of the screen")
    public void checkingTeamAndTeamNamesAndScoresScoreTeamScoreTeamAtTheCenterOfTheScreen(final String team1, final String team2, final String scoreTeam1, final String scoreTeam2) {
        Assert.assertTrue(BBC_SPORT.checkScoreCentralScreen(team1, team2, scoreTeam1, scoreTeam2));
    }
}
