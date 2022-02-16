package pages;

import manager.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoremIpsumPage extends BasePage {


    public void openPageSite(final String url) {
        DriverManager.getDriver().get(url);
    }

    @FindBy(xpath = "//a[contains(text(),'Pyccкий')]")
    private WebElement selectLanguage;

    public void clickRussianLanguage() {
        selectLanguage.click();
    }

    @FindBy(xpath = "//div[@id='Panes']/div")
    private List<WebElement> findWorldOnPage;

    public boolean checkSearchWordOnPage(final String keyword) {
        waitVisibilityOfElement(60, findWorldOnPage.get(0));
        if (findWorldOnPage.get(0).getText().contains(keyword)) {
            return true;
        } else return false;
    }

    @FindBy(xpath = "//input[@id='generate']")
    private WebElement pressButtonGenerate;

    public void clickPressButtonGenerate() {
        pressButtonGenerate.click();
    }

    @FindBy(xpath = "//div/p[contains(text(),'Lorem ipsum dolor sit amet, consectetur adipiscing elit')]")
    private List<WebElement> checkSearchWords;

    public boolean checkSearchSecondWords(final String keyword) {
        if (checkSearchWords.get(0).getText().contains(keyword)) {
            return true;
        } else return false;
    }


    public void clickLabelWords(final String keyword) {
        WebElement labelWords = DriverManager.getDriver().findElement(By.xpath("//label[@for='" + keyword + "']"));
        labelWords.click();

    }

    @FindBy(xpath = "//input[@name='amount']")
    private WebElement fieldForInput;

    public void inputMeaning(final String keyword) {
        fieldForInput.clear();
        fieldForInput.sendKeys(keyword);
    }

    @FindBy(xpath = "//div[@id='generated']")
    private WebElement generatedMeaning;

    public boolean checkGeneratedMeaning(final String keyword) {
        waitVisibilityOfElement(60, generatedMeaning);
        if (generatedMeaning.getText().contains(keyword)) {
            return true;
        } else return false;
    }

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkBoxStart;

    public void clickCheckBox() {
        checkBoxStart.click();
    }

    @FindBy(xpath = "//div[@id='lipsum']/p")
    private List<WebElement> checkNotStartLoremIpsum;

    public void resultCheckNotStartLoremIpsum(final String keyword) {
        for (int i = 0; i < checkNotStartLoremIpsum.size(); i++) {
            Assert.assertFalse(checkNotStartLoremIpsum.get(i).getText().contains(keyword));
        }
    }

    @FindBy(xpath = "//div[@id='lipsum']/p[contains(text(),'lorem')]")
    private WebElement paragraphContainingWord;

    public int countNumberOfParagraphWord() {
        // int count = paragraphContainingWord.size();
        int i = DriverManager.getDriver().findElements(By.xpath("//div[@id='lipsum']/p[contains(text(),'lorem')]")).size();
        return i;
    }

    @FindBy(xpath = "//a[@href='https://www.lipsum.com/']")
    private WebElement linkHomePage;


    public double averageNumberOfParagraph() {
        double average = 0;
        double result = 0;
        for (int i = 1; i <= 10; i++) {
            clickPressButtonGenerate();
            average = average + countNumberOfParagraphWord();
            result = average / i;
            linkHomePage.click();
        }

        return result;
    }
}
