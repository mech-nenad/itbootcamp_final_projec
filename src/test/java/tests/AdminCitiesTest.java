package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AdminCitiesPage;

public class AdminCitiesTest extends BaseTest {

    private AdminCitiesPage adminCitiesPage;
    private Faker faker;

    private String newNameCity;

    @Override
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        adminCitiesPage = new AdminCitiesPage(driver, driverWait);
        faker = new Faker();
        newNameCity = faker.address().cityName();
    }
    @Override
    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        homePage.loginButton();
        loginPage.inputValue("admin@admin.com", "12345");
    }

    @AfterMethod
    public void afterMethod() {
        adminCitiesPage.logoutSelected();
    }

    @Test   //Test 1
    public void loginAdmin() {
        adminCitiesPage.selectedAdminContent();

        adminCitiesPage.selectedContentCities();

        loginPage.logoutIsPresented();

        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));


    }

    @Test  //Test 2
    public void createNewCity() {

        adminCitiesPage.selectedAdminContent();
        adminCitiesPage.selectedContentCities();

        adminCitiesPage.createNewCity(newNameCity+"1");

        adminCitiesPage.saveCitySelected();

        Assert.assertTrue(adminCitiesPage.getMessageForCreateNewCity().contains("Saved successfully"));

    }


    @Test  //Test 3
    public void editCity() throws InterruptedException{

        adminCitiesPage.selectedAdminContent();
        adminCitiesPage.selectedContentCities();

        String newCityName = newNameCity+"2";
        adminCitiesPage.createNewCity(newCityName);
        adminCitiesPage.saveCitySelected();


        adminCitiesPage.searchCity(newCityName);

        adminCitiesPage.editCity(newCityName+"- edited");
        adminCitiesPage.saveCitySelected();

        Thread.sleep(2000);

        adminCitiesPage.againSearchCity(newCityName + "- edited");
        adminCitiesPage.editCity(newCityName);
        adminCitiesPage.saveCitySelected();

        Assert.assertTrue(adminCitiesPage.getMessageForCreateNewCity().contains("Saved successfully"));
    }

    @Test  //Test 4
    public void SearchCity() {


        adminCitiesPage.selectedAdminContent();

        adminCitiesPage.selectedContentCities();

        adminCitiesPage.createNewCity(newNameCity);
        adminCitiesPage.saveCitySelected();

        adminCitiesPage.searchCity(newNameCity);
        System.out.println(newNameCity);
        Assert.assertTrue(adminCitiesPage.getMessageCitySearch().contains(newNameCity));

    }

    @Test  //Test 5
    public void deleteCity() throws InterruptedException {

        adminCitiesPage.selectedAdminContent();

        adminCitiesPage.selectedContentCities();

        adminCitiesPage.createNewCity(newNameCity + "3");
        adminCitiesPage.saveCitySelected();
        adminCitiesPage.cancelNotificationMessage();
        adminCitiesPage.searchCity(newNameCity + "3");
        driverWait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]"), 1));
        Assert.assertTrue(adminCitiesPage.getTable().contains(newNameCity + "3"));
        adminCitiesPage.deleteCity();

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[6]/div/div/div[1]")));
        adminCitiesPage.deleteCityTable();


         System.out.println(adminCitiesPage.getMessageDeleteCity());
        Assert.assertTrue(adminCitiesPage.getMessageDeleteCity().contains("Deleted successfully"));

    }

}
