package pages;

import manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;

public class BbcSport extends BasePage {



    @FindBy(xpath = "//li[contains(@class,'sport-navigation')]//a[contains(@href,'football')]")
    private WebElement buttonSectionFootball;

    public void clickButtonSectionFootball() {
        buttonSectionFootball.click();
    }

    @FindBy(xpath = "//li[contains(@class,'sp-c-sport-navigation')]//a[@href='/sport/football/scores-fixtures']")
    private WebElement buttonScoresFixtures;

    public void clickButtonScoresFixtures() {
        buttonScoresFixtures.click();
    }

    public void clickDateChampionship(final String keyword) {
        DriverManager.getDriver().findElement(By.xpath("//span[contains(text(),'" + keyword + "')]")).click();
        waitForPageLoadComplete(60);
    }

    public boolean searchChampionship(final String keyword) {
        waitForPageLoadComplete(60);
        WebElement championship = DriverManager.getDriver().findElement(By.xpath("//h3[contains(text(),'" + keyword + "')]"));
        ((Locatable) championship).getCoordinates().inViewPort();
        return championship.isDisplayed();
    }

    public boolean checkSpecificScore(final String team1, final String team2, final String scoreTeam1, final String scoreTeam2) {
        boolean result = false;
        WebElement checkScoreTeam1 = DriverManager.getDriver().findElement(By.xpath("//span[contains(text(),'" + team1 + "')]|span[(contains(text() ,'" + scoreTeam1 + "'))]"));
        WebElement checkScoreTeam2 = DriverManager.getDriver().findElement(By.xpath("//span[contains(text(),'" + team2 + "')]|span[(contains(text() ,'" + scoreTeam2 + "'))]"));
        if ((checkScoreTeam1.isDisplayed()) & (checkScoreTeam2.isDisplayed())) {
            result = true;
        }
        return result;
    }

    public void clickLinkTeam(final String team1) {
        DriverManager.getDriver().findElement(By.xpath("//a//span[contains(text(),'" + team1 + "')]")).click();
    }

    public boolean checkScoreCentralScreen(final String team1, final String team2, final String scoreTeam1, final String scoreTeam2) {
        boolean result = false;
        WebElement checkScore1 = DriverManager.getDriver().findElement(By.xpath("//div[contains(@class,'header--football')]//span[contains(text(),'" + team1 + "')]|span[(text() ='" + scoreTeam1 + "')]"));
        WebElement checkScore2 = DriverManager.getDriver().findElement(By.xpath("//div[contains(@class,'header--football')]//span[contains(text(),'" + team2 + "')]|span[(text() ='" + scoreTeam2 + "')]"));
        if (checkScore1.isDisplayed() & checkScore2.isDisplayed()) {
            result = true;
        }
        return result;
    }
}
