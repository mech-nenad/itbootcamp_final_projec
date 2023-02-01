package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;
import pages.SingupPage;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;

    protected WebDriverWait driverWait;

    protected LoginPage loginPage;

    protected HomePage homePage;

    protected SingupPage singupPage;


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nenad\\Documents\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));

        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
        singupPage = new SingupPage(driver, driverWait);





        }

    @BeforeMethod
    public void beforMethod() {
        driver.get("https://vue-demo.daniel-avellaneda.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
