package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCitiesPage extends BasePage{


    @FindBy(xpath = "/html/body/div/div[1]/div/header/div/div[3]/button[1]/span")
    private WebElement adminContent;

    @FindBy(xpath = "/html/body/div/div[3]/div/a[1]/div[2]")
    private WebElement citiesContent;

    @FindBy(xpath = "/html/body/div/div[3]/div/a[2]/div[2]")
    private WebElement usersContent;

    @FindBy(xpath = "/html/body/div/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button/span")
    private WebElement createButton;

    @FindBy(id = "name")
    private WebElement inputNewCityName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement messageForCreateNewCity;

    @FindBy(xpath = "//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]")
    private WebElement selectedButtonSaveCity;


   @FindBy(xpath = "//*[@id=\"edit\"]/span")
    private WebElement editCityName;

    @FindBy(id = "name")
    private WebElement nameCityRename;

    @FindBy(id = "search")
    private WebElement searchCityName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[2]/div/div/div/div[2]/div/button")
    private WebElement clearSearchField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]")
    private WebElement messageCitiSearch;

    @FindBy(xpath = "//*[@id=\"delete\"]/span/i")
    private WebElement deleteButton;

    @FindBy(css = "#app > div.v-dialog__content.v-dialog__content--active > div > div > div.v-card__actions > button.v-btn.v-btn--text.theme--light.v-size--default.red--text.text--lighten3")
    private WebElement selectedDeleteButton;
    //@FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
  //@FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement messageDeleteCity;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement message;
    @FindBy(className = "text-left")
    private WebElement searchCity;

  //  @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/colgroup")
    @FindBy(xpath = "/html/body/div/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]")
    private WebElement table;

    @FindBy(xpath = "/html/body/div/div[1]/div/header/div/div[3]/button[2]/span")
    private WebElement logoutcontent;

    @FindBy(xpath = "/html/body/div/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]/button/span")
    private WebElement closeButton;

    @FindBy(xpath = "/html/body/div/div[6]/div/div/div[1]")
                   // /html/body/div/div[7]/div/div/div[1]
    private WebElement messageDoYouReallyWantToDelete;
    public AdminCitiesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    public void selectedAdminContent() {
        adminContent.click();
    }

    public void selectedContentCities() {
        citiesContent.click();
    }

    public void createNewCity(String nameCity) {
        createButton.click();
        inputNewCityName.clear();
        inputNewCityName.sendKeys(nameCity);
    }

    public String getMessageForCreateNewCity() {
        return messageForCreateNewCity.getText();
    }

    public void saveCitySelected() {
        selectedButtonSaveCity.click();
    }

    public void editCity(String nameCity) {
        editCityName.click();
        nameCityRename.sendKeys(Keys.CONTROL + "a");
        nameCityRename.sendKeys(Keys.DELETE);
        nameCityRename.sendKeys(nameCity);
    }

    public void searchCity(String citiName) {
        searchCityName.click();
        searchCityName.sendKeys(citiName);

    }
    public void againSearchCity(String cityName) {
        clearSearchField.click();
        searchCityName.sendKeys(cityName);
    }

    public String getMessageCitySearch() {
        return messageCitiSearch.getText();
    }

    public void deleteCity() {
        deleteButton.click();
    }
    public void deleteCityTable() {
        selectedDeleteButton.click();
    }

    public String getMessageDeleteCity() {
        return messageDeleteCity.getText();
    }

    public String getSearchCity() {
        return searchCity.getText();
    }

    public boolean logoutIsPresented() {
    return  logoutcontent.isDisplayed();
    }

    public void logoutSelected() {
        logoutcontent.click();
    }

    public WebElement getMessageElement() {
        return message;
    }
    public void cancelNotificationMessage() {
        closeButton.click();
    }

    public String getTable() {
        return table.getText();
    }

    public String getMessageDoYouReallyWantToDelete() {
        return messageDoYouReallyWantToDelete.getText();
    }
}

