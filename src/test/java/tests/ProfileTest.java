package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProfilePage;

public class ProfileTest extends BaseTest{

    private ProfilePage profilePage;

    private Faker faker;


    @Override
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        profilePage = new ProfilePage(driver, driverWait);
        faker = new Faker();
    }
    @Override
    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        homePage.loginButton();
        loginPage.inputValue("admin@admin.com","12345");
    }


    @AfterMethod
    public void afterMethod() {
        loginPage.logoutSelected();
    }

    @Test   // Test 1
    public void editsProfile() throws InterruptedException {

        profilePage.selectedProfile();
        String name = faker.name().fullName();

        profilePage.changeName(name);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated((By.id("name")) ));

        String phone = faker.phoneNumber().cellPhone();
        profilePage.changePhone(phone);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated((By.id("phone")) ));

        String country = faker.country().name();
        profilePage.changeCountry(country);

        String twitter = "https://tikva.info";
        profilePage.changeUrlTwitter(twitter);

        Thread.sleep(2000);

        String gitHub = "http://tikva2.net";
        profilePage.changeUrlGitHub(gitHub);

        profilePage.changeCity("New York");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated((By.id("city")) ));

        profilePage.selectedSave();

        Thread.sleep(500);

        Assert.assertEquals(profilePage.getChangeName1(), name);
        Assert.assertEquals( profilePage.getChangeCity(),"New York");
        Assert.assertEquals(profilePage.getChangeUrlGitHub(), gitHub);
        Assert.assertEquals(profilePage.getChangeCountry(), country);
        Assert.assertEquals(profilePage.getChangeUrlTwitter(), twitter);
        Assert.assertEquals(profilePage.getChangePhone(),phone);

        Assert.assertTrue(profilePage.getMessageForSaveChange().contains("Profile saved successfuly"));

    }
}
