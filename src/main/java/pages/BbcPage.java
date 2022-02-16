package pages;

import manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BbcPage extends BasePage {

    public void openHomePage(final String url) {
        DriverManager.getDriver().get(url);
    }

    @FindBy(xpath = "//div[@id='orb-nav-links']//a[contains(@href,'news')]")
    private WebElement barMenu;

    public void clickOnNavigationButtons(final String keyword) {
        waitVisibilityOfElement(120, barMenu);
        WebElement button = DriverManager.getDriver().findElement(By.xpath("//div[@id='orb-nav-links']//a[contains(@href,'" + keyword + "')]"));
        button.click();
    }


    public boolean checkTopHeading(final String keyword) {
        WebElement sectionHeading = DriverManager.getDriver().findElement(By.xpath("//div[@data-entityid='container-top-stories#1']//h3[contains(text(),'" + keyword + "')]"));
        return sectionHeading.isDisplayed();
    }

    public boolean checkSecondHeading(final String keyword) {
        WebElement secondHeading = DriverManager.getDriver().findElement(By.xpath("//div[contains(@data-entityid,'container-top-stories#')]//h3[contains(text(),'" + keyword + "')]"));
        return secondHeading.isDisplayed();
    }

    @FindBy(xpath = "//input[@id='orb-search-q']")
    WebElement searchFiled;

    String link;
    public void storesLinkHeadLineNews(final String keyword) {
        WebElement headLineNews = DriverManager.getDriver().findElement(By.xpath("//nav[@class='nw-c-nav__wide']//a[contains(@href,'" + keyword + "')]"));
        link = headLineNews.getAttribute("href");

    }
    public void enterTextSearchFiled(){
        searchFiled.clear();
        searchFiled.sendKeys(link, Keys.ENTER);
    }

    @FindBy (xpath = "//span[@aria-hidden='false']")
    private List<WebElement> nameArticleSearchPage;

    public boolean checkFirstNameArticle(final String keyword){
       return nameArticleSearchPage.get(0).getText().contains(keyword);
    }

    public void clickButtonSubtitle(final String keyword){
        DriverManager.getDriver().findElement(By.xpath("//li[contains(@class,'wide')]//a[contains(@href,'"+keyword+"')]")).click();
    }
    @FindBy(xpath = "//li[contains(@class,'secondary')]//a[@href='/news/have_your_say']")
    private WebElement buttonCoronavirusStories;

    public void clickButtonCoronavirusStories(){
        buttonCoronavirusStories.click();
    }

    @FindBy(xpath = "//a[contains(@href,'52143212')]")
    private WebElement linkQuestion;

    public void clickLinkQuestion(){
        linkQuestion.click();
    }

    @FindBy(xpath = "//textarea")
    private WebElement textArea;

    public void scrollingToTextArea(){
        ((Locatable) textArea).getCoordinates().inViewPort();
    }

    @FindBy(xpath = "//button[@aria-label='Close']")
    private WebElement closePopUpWindow;

    public void clickClosePopUpWindow(){
        if (closePopUpWindow.isDisplayed()==true){
        closePopUpWindow.click();}
    }

}
