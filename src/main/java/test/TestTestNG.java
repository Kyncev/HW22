package test;

import configuratio.BaseClass;
import liseners.TestTestNGLisener;
import org.testng.annotations.*;
@Listeners(TestTestNGLisener.class)
public class TestTestNG extends BaseClass {
    @BeforeClass
    public void bef(){
        System.out.println("before class");
    }
    @BeforeMethod
    public void bM(){
        System.out.println("before Method");
    }
    @Test(description = "some test<data>",groups = {"smoke", "regrasion", "MyTest"}, priority = 10)
    public void test1(){
        System.out.println("test1");
    }
    @Test(groups = {"MyTest"}, dependsOnMethods = {"test3"}, alwaysRun = true)
    public void test2(){
        System.out.println("test2");
    }
    @Test(priority = 1)
    public void test3() throws Exception {
        System.out.println("test3");
        driver.get("https://www.youtube.com");
        throw new Exception("hi");
    }
   @AfterMethod
   public void aM(){
       System.out.println("after Method");
   }
    @AfterClass
    public void afteR(){
       System.out.println("after class");
   }
}
