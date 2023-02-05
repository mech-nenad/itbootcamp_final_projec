package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BasePage{

    @FindBy(xpath = "/html/body/div/div/div/header/div/div[3]/a[3]/span")
    private WebElement loginContent;




    public LandingPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void loginButton() {
        loginContent.click();
    }

    public boolean isLoginFormPresented() {
        return loginContent.isDisplayed();
    }
}
