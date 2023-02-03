package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage{

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]/span")
    private WebElement selectedMyProfileButton;

    @FindBy(id = "name")
    private WebElement changeName;

    @FindBy(id = "phone")
    private WebElement changePhone;

    @FindBy(id = "city")
    private WebElement changeCity;

    @FindBy(id = "country")
    private WebElement changeCountry;

    @FindBy(id = "urlTwitter")
    private WebElement changeUrlTwitter;

    @FindBy(id = "urlGitHub")
    private WebElement changeUrlGitHub;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button")
    private WebElement selectedSaveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement messageForSaveChange;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[4]/span/div/div/div[1]/div[1]/div[1]/div/button")
    private WebElement selectedDeleteButtonForCity;

    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void selectedProfile() {
        selectedMyProfileButton.click();
    }

    public void changeAllValues(String inputName, String inputPhone, String inputCity,  String inputUrlTwitter, String inputUrlGitHub) {
        changeName.clear();
        changeName.sendKeys(inputName);
        changePhone.clear();
        changePhone.sendKeys(inputPhone);
        changeCity.clear();
        changeCity.sendKeys(inputCity);
        changeUrlTwitter.clear();
        changeUrlTwitter.sendKeys(inputUrlTwitter);
        changeUrlGitHub.clear();
        changeUrlGitHub.sendKeys(inputUrlGitHub);
        selectedSaveButton.click();

    }
    public void selectedSave() {
        selectedSaveButton.click();
    }

    public String getMessageForSaveChange() {
        return messageForSaveChange.getText();
    }

    public void changeName1(String inputName) {
        changeName.sendKeys(Keys.CONTROL + "a");
        changeName.sendKeys(Keys.DELETE);
        changeName.sendKeys(inputName);
    }
    public void changePhone1(String inputPhone) {
        changePhone.sendKeys(Keys.CONTROL + "a");
        changePhone.sendKeys(Keys.DELETE);
        changePhone.sendKeys(inputPhone);
    }
    public void changeCountry1(String inputCountry) {
        changeCountry.sendKeys(Keys.CONTROL + "a");
        changeCountry.sendKeys(Keys.DELETE);
        changeCountry.sendKeys(inputCountry);
    }
    public void changeUrlTwitter1(String inputTwitter) {
        changeUrlTwitter.sendKeys(Keys.CONTROL + "a");
        changeUrlTwitter.sendKeys(Keys.DELETE);
        changeUrlTwitter.sendKeys(inputTwitter);
    }
    public void changeUrlGitHub1(String inputGitHub) {
        changeUrlGitHub.sendKeys(Keys.CONTROL + "a");
        changeUrlGitHub.sendKeys(Keys.DELETE);
        changeUrlGitHub.sendKeys(inputGitHub);
    }
    public void changeCity1() {
        selectedDeleteButtonForCity.click();
        Select category = new Select(changeCity);
        category.selectByIndex(1);
    }
}
