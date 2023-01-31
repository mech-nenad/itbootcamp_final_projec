package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SingupPage;

public class SingupTest extends BaseTest{

//    protected SingupPage singupPage;
//
////    @BeforeMethod
////
////    public void beforeMethod() {
////        super.beforMethod();
////        singupPage.singupSelected();
//

    @Test
    public  void singupForm() {
        singupPage.singupSelected();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }



    @Test
    public void displaysErrorWhenUserAlreadyExists() {
        singupPage.singupSelected();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        singupPage.inputValueForSingup("Test Test", "admin@admin.com", "123654", "123654");


        Assert.assertTrue(driver.getCurrentUrl().contains("/signup "));

//        Assert.assertTrue();

    }
}
