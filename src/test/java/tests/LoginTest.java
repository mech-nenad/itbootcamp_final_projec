package tests;

import com.github.javafaker.Faker;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    private Faker faker;



    @Test  //Test 1
    public void loginTest() {

        homePage.loginButton();

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test   // Test 2
    public void checkInputValue() {
        homePage.loginButton();

        String emailValue = "email";
        Assert.assertEquals(loginPage.getInputEmail(), emailValue);

        String passwordValue = "password";
        Assert.assertEquals(loginPage.getInputPassword(), passwordValue);
    }


    @Test   // Test 3
    public void displaysError() {
        homePage.loginButton();
        faker = new Faker();
        String emailFakerInput = faker.internet().emailAddress();

        String passwordFakerInput = faker.internet().password();

        loginPage.inputValue(emailFakerInput, passwordFakerInput);


        Assert.assertTrue(loginPage.getMessageInvalid().contains("User does not exists"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));


    }

    @Test   // Test 4
    public void passwordWrong() throws InterruptedException {
        homePage.loginButton();
        faker = new Faker();
        String passwordFakerInput = faker.internet().password();

        loginPage.inputValue("admin@admin.com", passwordFakerInput);

        Assert.assertTrue(loginPage.getMessageForWrongPassword().contains("Wrong password"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));

    }

    @Test   //Test 5
    public void validInput() {
        homePage.loginButton();
        loginPage.inputValue("admin@admin.com","12345");

        driverWait.until(ExpectedConditions.urlContains("/home"));


        Assert.assertTrue(driver.getCurrentUrl().contains("/home"));
    }

    @Test   // Test 6
    public void checkLogoutButton() {
        homePage.loginButton();
        loginPage.inputValue("admin@admin.com","12345");


        loginPage.logoutIsPresented();
        loginPage.logoutSelected();


        driver.get("https://vue-demo.daniel-avellaneda.com"+"/home");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));

    }

}
