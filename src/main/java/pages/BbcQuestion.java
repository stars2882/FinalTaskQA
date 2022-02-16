package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import manager.DriverManager;

public class BbcQuestion extends BasePage{

    public void openHomePage(final String url) {
        DriverManager.getDriver().get(url);
    }

    @FindBy(xpath = "//input[@aria-label='Name']")
    private WebElement fieldName;

    @FindBy(xpath = "//input[@aria-label='Email address']")
    private WebElement fieldEmail;
    @FindBy(xpath = "//input[@aria-label='Contact number']")
    private WebElement fieldContactNumber;
    @FindBy(xpath = "//input[@aria-label='Location ']")
    private WebElement fieldLocation;
    @FindBy(xpath = "//input[@aria-label='Age']")
    private WebElement fieldAge;
    @FindBy (xpath = "//textarea[@class='text-input--long']")
    private WebElement fieldQuestion;

    public void fillingFormsWithData(final String question, final String name, final String email, final String phone, final String location, final String age){
        fieldQuestion.sendKeys(question);
        fieldName.sendKeys(name);
        fieldEmail.sendKeys(email);
        fieldContactNumber.sendKeys(phone);
        fieldLocation.sendKeys(location);
        fieldAge.sendKeys(age);

    }

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    private WebElement buttonSubmit;

    public void clickButtonSubmit(){
        buttonSubmit.click();
    }

    @FindBy(xpath = "//div[@class='input-error-message']")
    private WebElement checkErrorMessage;

    public boolean checkSubmitToErrors(){
        waitVisibilityOfElement(20,checkErrorMessage);
        return checkErrorMessage.isDisplayed();
    }

    @FindBy (xpath = "//input[@type='checkbox']")
    private WebElement checkBoxForm;

    public void clickCheckBoxForm(){
        checkBoxForm.click();
    }

}
