package day05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_DataProvider {

    /**
     * Aşağıdaki ikili ile Dataproviderın içindeki bütün veriler tek tek test e gönderilerek
     * data sayısı kadar test çalıştırılır, dataların olduğu yere DataProvider annottion ı konur.
     * çalıştırılacak teste ise dataProvider = "getData"  bölümü eklenir.
     * Dataprovider bir testi birden fazla DATA ile çalıştırmak için kullanılır.
     * XML filer file gruplama, parallel, ve farklı tesleri koordine edip bir arada çalıştırmak için kullanılır.
     */


    @Test(dataProvider = "myDatas")
    void usernameTest(String username) {
        System.out.println("username = " + username);
    }

    @DataProvider// bu metoda dataprovider görevi verildi.
    public Object[] myDatas() {// DataProvider olarak kullanılcak metodun tipi Object olmak zorunda.
        Object[] users = {"Yakup", "Kadri", "Sait", "Faik"};
        return users;
    }


}
