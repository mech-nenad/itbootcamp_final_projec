package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AdminCitiesPage;

public class AdminCitiesTest extends BaseTest{

    private AdminCitiesPage adminCitiesPage;
    private Faker faker;

    private String newNameCity;

    @Override
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        adminCitiesPage = new AdminCitiesPage(driver, driverWait);
        faker = new Faker();
        newNameCity =  faker.address().cityName(); // faker nije inicijalizovan, nullPointer
        // poenta je da imas newNameCity na nivou klase, tako da sve metode mogu da pristupe tom imenu
    }

    @Test   //Test 1
    public void loginAdmin() {
        homePage.loginButton();
        loginPage.inputValue("admin@admin.com", "12345");


        adminCitiesPage.selectedAdminContent();


        adminCitiesPage.selectedContentCities();

        loginPage.logoutIsPresented();

        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));


    }

    @Test  //Test 2
    public void createNewCity() {

        faker = new Faker();

        homePage.loginButton();
        loginPage.inputValue("admin@admin.com", "12345");

        adminCitiesPage.selectedAdminContent();
        adminCitiesPage.selectedContentCities();

        adminCitiesPage.createNewCity(newNameCity);

        System.out.println(newNameCity);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        adminCitiesPage.saveCitySelected();

        Assert.assertTrue(adminCitiesPage.getMessageForCreateNewCity().contains("Saved successfully"));

    }


    @Test  //Test 3
    public  void editCity() {
        homePage.loginButton();
        loginPage.inputValue("admin@admin.com", "12345");

        adminCitiesPage.selectedAdminContent();
        adminCitiesPage.selectedContentCities();


        adminCitiesPage.createNewCity(newNameCity);
        adminCitiesPage.saveCitySelected();


        adminCitiesPage.searchCity(newNameCity);

        adminCitiesPage.editCity(newNameCity + "- edited");
        adminCitiesPage.saveCitySelected();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



        adminCitiesPage.againSearchCity(newNameCity + "- edited");
        adminCitiesPage.editCity(newNameCity);
        adminCitiesPage.saveCitySelected();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test  //Test 4
    public void SearchCity() {
        homePage.loginButton();
        loginPage.inputValue("admin@admin.com", "12345");

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
        homePage.loginButton();
        loginPage.inputValue("admin@admin.com", "12345");

        adminCitiesPage.selectedAdminContent();

        adminCitiesPage.selectedContentCities();

        adminCitiesPage.createNewCity(newNameCity);
        adminCitiesPage.saveCitySelected();

        adminCitiesPage.searchCity(newNameCity);
        driverWait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/colgroup"),1));

        // driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"delete\"]/span/i")));
        Thread.sleep(2000);
         adminCitiesPage.deleteCity();

        Thread.sleep(5000);

        // Nije hteo da mi selektuje delete dugme!
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), ' Delete ')")));
        adminCitiesPage.deleteCityTabel();

        Thread.sleep(2000);

//
//        Assert.assertTrue(adminCitiesPage.getMessageDeleteCity().contains("Deleted successfully"));


    }

}
/*
Podaci: editovani grad iz testa #3
        assert:
        •	U polje za pretragu uneti staro ime grada
        •	Sacekati da broj redova u tabeli bude 1
        •	Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
        •	Kliknuti na dugme Delete iz prvog reda
        •	Sacekati da se dijalog za brisanje pojavi
        •	Kliknuti na dugme Delete iz dijaloga
        •	Sacekati da popu za prikaz poruke bude vidljiv
        •	Verifikovati da poruka sadrzi tekst Deleted successfully
*/