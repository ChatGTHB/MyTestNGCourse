package day05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _03_DataProvider_Multidimensional {
    @Test(dataProvider = "userData")
    void usernameTest(String username, String password) {
        System.out.println("user = " + username + " " + password);
    }

    @DataProvider
    public Object[][] userData() { // The type of the method to be used as DataProvider must be Object.
        Object[][] data = {
                {"Yakup", ".-*4569ĞŞ"},
                {"Kadri", "TJHhjK4587-"},
                {"Ziya", "vcb74-*Q"},
                {"Osman", "12Ü,İŞ,1vs"}
        };
        return data;
    }
}
