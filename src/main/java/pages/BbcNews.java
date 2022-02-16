package pages;

import manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BbcNews extends BasePage {
    @FindBy(xpath = "//label[@for='orb-search-q']")
    WebElement searchFiled;

    String link;
    public void storesLinkHeadLineNews(final String keyword) {
        WebElement headLineNews = DriverManager.getDriver().findElement(By.xpath("//nav[@class='nw-c-nav__wide']//span[contains(text(),'" + keyword + "')]"));
        link = headLineNews.getAttribute("href");

    }

    public void enterTextSearchFiled() {
        searchFiled.sendKeys(link);
    }
}
