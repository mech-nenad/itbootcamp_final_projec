package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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


    @Test   // Test 1
    public void editsProfile() {
        homePage.loginButton();
        loginPage.inputValue("admin@admin.com","12345");

        profilePage.selectedProfile();
        String name = faker.name().fullName();


        profilePage.changeName1(name);
        System.out.println(name);


        String phone = faker.phoneNumber().phoneNumber();
        profilePage.changePhone1(phone);
//
//        String city = faker.address().cityName();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String country = faker.country().name();
        profilePage.changeCountry1(country);
//
//
        String twitter = "https://Tikva.info";
        profilePage.changeUrlTwitter1(twitter);

//
        String gitHub = "http://Tikva2.net";
        profilePage.changeUrlGitHub1(gitHub);

//
//        profilePage.changeAllValues(name, phone, city, twitter, gitHub);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Nisam uspeo da izaberem grad

        // profilePage.changeCity1();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        profilePage.selectedSave();

         Assert.assertTrue(profilePage.getMessageForSaveChange().contains("Profile saved successfuly"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
