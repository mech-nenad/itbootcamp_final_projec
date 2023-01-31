package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    private Faker faker;


//    @Test
//    public void isLoginPreseted() {
//        Assert.assertTrue(loginPage.isLoginFormPresented());
//    }

    @Test
    public void loginTest() {

            homePage.loginButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void checkInputValue() {
        homePage.loginButton();

        Assert.assertTrue(loginPage.getInputEmail().contains("type"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void displaysError() {
        homePage.loginButton();
        faker = new Faker();
        String emailFakerInput = faker.internet().emailAddress();

        String passwordFakerInput = faker.internet().password();

        loginPage.inputValue(emailFakerInput, passwordFakerInput);



        Assert.assertTrue(loginPage.getMessageInvalid().contains("User does not exists"));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void passwordWrong() {
        homePage.loginButton();
        faker = new Faker();
        String passwordFakerInput = faker.internet().password();

        loginPage.inputValue("admin@admin.com", passwordFakerInput);

        Assert.assertTrue(loginPage.getMessageForWrongPassword().contains("Wrong password"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login "));

    }

    @Test
    public void validInput() {
        homePage.loginButton();
        loginPage.inputValue("admin@admin.com","12345");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertTrue(driver.getCurrentUrl().contains("/home"));
    }

    @Test
    public void checkLogoutButton() {
        homePage.loginButton();
        loginPage.inputValue("admin@admin.com","12345");

        loginPage.logoutIsPresented();
        loginPage.logoutSelected();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertTrue(driver.getCurrentUrl().contains("/home"));

    }
}
