package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LandingPage;
import pages.LoginPage;
import pages.SingupPage;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;

    protected WebDriverWait driverWait;
    protected LoginPage loginPage;
    protected LandingPage homePage;
    protected SingupPage singupPage;

    protected final String baseUrl = "https://vue-demo.daniel-avellaneda.com";


    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        homePage = new LandingPage(driver, driverWait);

        loginPage = new LoginPage(driver, driverWait);

        singupPage = new SingupPage(driver, driverWait);

        }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://vue-demo.daniel-avellaneda.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
