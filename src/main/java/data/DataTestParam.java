package data;

import org.testng.annotations.DataProvider;

public class DataTestParam {
    @DataProvider
    public static Object[][] getStrings() {
        return new Object[][]{
                {"Mario"}, {"Stich"}, {"Mason"},
        };
    }
}