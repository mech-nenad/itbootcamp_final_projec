package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SingUpTest extends BaseTest{

        private Faker faker;

    @Test(priority =  1)  //Test 1
    public  void singUpForm() {

        singupPage.logoutButtonSelected();

        singupPage.singupSelected();

        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));

    }

    @Test //Test2
    public void checksInputTypes() {
        singupPage.singupSelected();

        Assert.assertEquals(singupPage.getInputEmail(), "email");

        Assert.assertEquals(singupPage.getInputPassword(), "password");

        Assert.assertEquals(singupPage.getInputAgainPassword(), "password");

    }


    @Test //Test3
    public void displaysErrorWhenUserAlreadyExists() {

        singupPage.singupSelected();

        driverWait.until(ExpectedConditions.urlContains("/signup"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));

        singupPage.inputValueForSingUp("Test Test", "admin@admin.com", "123654", "123654");

        Assert.assertTrue(singupPage.getMessageEmailAlreadyExists().contains("E-mail already exists"));

    }

    @Test   //Test 4
    public void singUp() throws InterruptedException {

        singupPage.singupSelected();

        singupPage.inputValueForSingUp("Pera Peric", "peraperoc3@gmail.com", "123456", "123456");

        Thread.sleep(2000);

        Assert.assertTrue(singupPage.getImportantMessage().contains("IMPORTANT: Verify your account"));

        singupPage.closeDialog();

    }
}
