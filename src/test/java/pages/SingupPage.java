package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingupPage extends BasePage{


    @FindBy(xpath = "/html/body/div/div[1]/div/header/div/div[3]/a[4]/span")
    private WebElement singupContent;

    @FindBy(id = "name")
    private WebElement inputName;

    @FindBy(id = "email")
    private WebElement inputEmail;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(id = "confirmPassword")
    private WebElement inputAgainPassword;

    @FindBy(xpath = "/html/body/div/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button/span")
    private WebElement selectedSingMeUp;

    @FindBy(xpath = "/html/body/div/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]")
    private WebElement messageForSingup;

    @FindBy(xpath = "/html/body/div/div[4]/div/div/div[1]")
    private WebElement importantMessage;

    @FindBy(xpath = "/html/body/div/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]")
    private WebElement messageEmailAlreadyExists;

    @FindBy(xpath = "/html/body/div/div[1]/div/header/div/div[3]/button[1]/span")
    private WebElement logoutButton;

    @FindBy(className = "btnClose")
    private WebElement btnClose;


    public SingupPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void singupSelected() {
        singupContent.click();
    }

    public void inputValueForSingUp(String name, String email, String password, String confirmPassword) {
        inputName.sendKeys(name);
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        inputAgainPassword.sendKeys(confirmPassword);
        selectedSingMeUp.click();


    }

    public String getMessageForSingUp() {
        return messageForSingup.getText();
    }

    public String  getInputName() {
        return inputName.getAttribute("type");
    }

    public String getInputEmail() {
        return inputEmail.getAttribute("type");
    }

    public String getInputPassword() {
        return inputPassword.getAttribute("type");
    }

    public String  getInputAgainPassword() {
        return inputAgainPassword.getAttribute("type");
    }

    public String getImportantMessage() {
        return importantMessage.getText();
    }

    public String getMessageEmailAlreadyExists() {
        return messageEmailAlreadyExists.getText();
    }
    public void logoutButtonSelected() {
        logoutButton.click();
    }

    public void closeDialog() {
        btnClose.click();
    }
}
