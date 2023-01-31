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



    public SingupPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void singupSelected() {
        singupContent.click();
    }

//    public String getSingupContent() {
//        return singupContent.getAttribute();
//    }



    public void inputValueForSingup(String name, String email, String password, String confirmPassword) {
        inputName.sendKeys(name);
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        inputAgainPassword.sendKeys(confirmPassword);
        selectedSingMeUp.click();


    }

    public String getMessageForSingup() {
        return messageForSingup.getText();
    }
}
