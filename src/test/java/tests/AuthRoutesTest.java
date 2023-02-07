package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTest extends BaseTest{

   @Test  // Test 1
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {


       driver.get(baseUrl+"/home");
       Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
   }

   @Test  // Test 2
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {

       driver.get(baseUrl + "/profile");
       Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
   }

   @Test  //Test 3
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {

       driver.get(baseUrl + "/admin/cities");
       Assert.assertTrue(driver.getCurrentUrl().contains("/login"));

   }

   @Test  //Test 4
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
       driver.get(baseUrl + "/admin/users");
       Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
   }
}
