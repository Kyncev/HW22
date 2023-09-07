package test;
import configuratio.BaseClass;
import data.DataMainPage;
import jdk.jfr.Description;
import objects.CertificatePage;
import objects.HillelMainPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TestHillelSearch extends BaseClass {
    HillelMainPage hillelMainPage;
    CertificatePage hillelCertPage;
    private final String mainURL="https://ithillel.ua/";
    private final String CertURL="https://certificate.ithillel.ua";

    @BeforeClass
    public void bb() {
        driver.get(mainURL);
        hillelMainPage= new HillelMainPage(driver);
    }
    @Test
    public void chekCourseMenu() throws Exception {
        //throw new Exception("dd");
        Assert.assertTrue(hillelMainPage.openCourseFrame());
    }
    @Description("Some detailed test description")
    @Test(dependsOnMethods = {"chekCourseMenu"},dataProviderClass = DataMainPage.class,dataProvider = "getSearchVariable")
    public void searchCourseTest(String searchVariable, List<String> searchResults) throws InterruptedException {
        Assert.assertEquals(hillelMainPage.getVariablesSearch(searchVariable),searchResults);
    }
    @AfterClass
    public void cc() {
        driver.get(CertURL);
        hillelCertPage= new CertificatePage(driver);
    }


    @Test(dependsOnMethods = {"chekCourseMenu"},dataProviderClass = DataMainPage.class, dataProvider = "getCertStrings", alwaysRun = true)
    public void testParam3(String strings){
        System.out.println(strings);
    }
}
