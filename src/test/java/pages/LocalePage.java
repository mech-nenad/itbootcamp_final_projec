package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocalePage extends BasePage{

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button/span")
    private WebElement selectedLanguage;

    @FindBy(xpath = "//*[@id=\"list-item-75\"]/div")
    private WebElement selectedLanguageSpanish;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement titleMessage;

    @FindBy(xpath = "//*[@id=\"list-item-73\"]/div")
    private WebElement selectedLanguageEnglish;

    @FindBy(xpath = "//*[@id=\"list-item-77\"]/div")
    private WebElement selectedLanguageFrench;

    public LocalePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void selectedlanguageMeni() {
        selectedLanguage.click();
    }

    public void selectedLanguageSpanish() {
        selectedLanguageSpanish.click();
    }

    public String getTitleMessage() {
        return titleMessage.getText();
    }

    public void selectedLanguageEnglish() {
        selectedLanguageEnglish.click();
    }

    public void selectedLanguageFrench() {
        selectedLanguageFrench.click();
    }
}
