package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LocalePage;

public class LocaleTest extends BaseTest{

    protected LocalePage localePage;


    @Override
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        localePage = new LocalePage(driver, driverWait);
    }

    @Test   //Test 1
    public void setLocaleToES() {
        localePage.selectedLanguageMeni();

        localePage.selectedLanguageSpanish();

        driverWait.withMessage("Página de aterrizaje");
        Assert.assertTrue(localePage.getTitleMessage().contains("Página de aterrizaje"));
    }

    @Test  //Test 2
    public void setLocaleToEN() {
        localePage.selectedLanguageMeni();
        localePage.selectedLanguageEnglish();

        driverWait.withMessage("Landing");
        Assert.assertTrue(localePage.getTitleMessage().contains("Landing"));
    }

    @Test  //Test 3
    public void setLocaleToFR() {
        localePage.selectedLanguageMeni();
        localePage.selectedLanguageFrench();

        driverWait.withMessage("Page d'atterrissage");
        Assert.assertTrue(localePage.getTitleMessage().contains("Page d'atterrissage"));
    }


}
