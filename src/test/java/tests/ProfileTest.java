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
        Assert.assertEquals(name, profilePage.getChangeName1());
        driverWait.until(ExpectedConditions.visibilityOfElementLocated((By.id("name")) ));

        String phone = faker.phoneNumber().cellPhone();
        profilePage.changePhone(phone);
        Assert.assertEquals(phone, profilePage.getChangePhone());
        driverWait.until(ExpectedConditions.visibilityOfElementLocated((By.id("phone")) ));

        String country = faker.country().name();
        profilePage.changeCountry(country);
        Assert.assertEquals(country, profilePage.getChangeCountry());

        String twitter = "https://Tikva.info";
        profilePage.changeUrlTwitter(twitter);
        Assert.assertEquals(twitter, profilePage.getChangeUrlTwitter());


        String gitHub = "http://Tikva2.net";
        profilePage.changeUrlGitHub(gitHub);
        Assert.assertEquals(gitHub, profilePage.getChangeUrlGitHub());

        profilePage.changeCity();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated((By.id("city")) ));
        //Assert.assertEquals( profilePage.getChangeCity());
//        Thread.sleep(500);


        profilePage.selectedSave();
        Thread.sleep(500);

         Assert.assertTrue(profilePage.getMessageForSaveChange().contains("Profile saved successfuly"));

    }
}
