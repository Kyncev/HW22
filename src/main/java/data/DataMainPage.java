package data;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class DataMainPage {
    @DataProvider
    public Object[][] getSearchVariable(){
        return new Object[][]{
                {"QA", Arrays.asList("QA Manual","QA Automation — Java","QA Technical Pro")},
                {"DevOps",Arrays.asList("DevOps","Project Management","Full-Stack — PHP")}
        };
    }
    @DataProvider
    public static Object[][] getCertStrings() {
        return new Object[][]{
                {"45924126"}, {"78008248"}, {"82853872"}
        };
    }

}