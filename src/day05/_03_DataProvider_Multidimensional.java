package day05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _03_DataProvider_Multidimensional {
    @Test(dataProvider = "userData")
    void usernameTest(String username, String password) {
        System.out.println("user = " + username + " " + password);
    }

    @DataProvider
    public Object[][] userData() {// DataProvider olarak kullanılcak metodun tipi Object olmak zorunda.
        Object[][] data = {
                {"Yakup", ".-*4569ĞŞ"},
                {"Kadri", "TJHhjK4587-"},
                {"Sait", "vcb74-*Q"},
                {"Faik", "12Ü,İŞ,1vs"}
        };
        return data;
    }
}
