package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SingupTest extends BaseTest{


    @Test //Test 1
    public  void singupForm() {
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


        singupPage.inputValueForSingup("Test Test", "admin@admin.com", "123654", "123654");


        Assert.assertTrue(singupPage.getMessageEmailAlreadyExists().contains("E-mail already exists"));


    }

    @Test   //Test 4
    public void singup() {
        singupPage.singupSelected();

        singupPage.inputValueForSingup("Pera Peric", "pera.peric3@gmail.com", "123456", "123456");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertTrue(singupPage.getImportantMessage().contains("Verify your account"));

    }
}
