package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTest extends BaseTest{

   @Test  // Test 1
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {


       driver.get("https://vue-demo.daniel-avellaneda.com"+"/home");
       Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
   }

   @Test  // Test 2
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {

       driver.get("https://vue-demo.daniel-avellaneda.com" + "/profile");
       Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
   }

   @Test  //Test 3
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {

       driver.get("https://vue-demo.daniel-avellaneda.com" + "/admin/cities");
       Assert.assertTrue(driver.getCurrentUrl().contains("/login"));

   }

   @Test  //Test 4
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
       driver.get("https://vue-demo.daniel-avellaneda.com" + "/admin/users");
       Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
   }
}
