package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

//    @FindBy(xpath = "/html/body/div/div/div/header/div/div[3]/a[3]/span")
//    private WebElement logincontent;

    @FindBy(id = "email")
    private WebElement inputEmail;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(xpath = "/html/body/div/div[1]/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button/span")
    private WebElement loginbuttin;

    @FindBy(xpath = "/html/body/div/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement messageInvalid;

    @FindBy(xpath = "/html/body/div/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement messageForWrongPassword;

    @FindBy(xpath = "/html/body/div/div[1]/div/header/div/div[3]/button[2]/span")
    private WebElement logoutcontent;


    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }




    public void inputValue(String userEmail, String userPassword) {
    this.inputEmail.clear();
    this.inputEmail.sendKeys(userEmail);

    this.inputPassword.clear();
    this.inputPassword.sendKeys(userPassword);

    this.loginbuttin.click();


    }

    public boolean logoutIsPresented() {
        return logoutcontent.isDisplayed();
    }
    public void logoutSelected() {
        logoutcontent.click();
    }

    public String getInputEmail() {
        return inputEmail.getAttribute("type");
    }

    public String getInputPassword() {
        return inputPassword.getAttribute("type");
    }

    public String getMessageInvalid() {
        return messageInvalid.getText();
    }

    public String getMessageForWrongPassword() {
        return messageForWrongPassword.getText();
    }
}
