package day05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_DataProvider {

    /**
     With the following binary, all the data in the Dataprovider is sent to the test one by one,
     and the test is run as much as the number of data,
     and the DataProvider annotation is placed where the data is.
     dataProvider = "getData" section is added to the test to be run.
     Dataprovider is used to run a test with more than one DATA. XML filer file is used to
     coordinate grouping, parallel, and different tests and run them together.
     */

    @Test(dataProvider = "myDatas")
    void usernameTest(String username) {
        System.out.println("username = " + username);
    }

    @DataProvider // This method has been assigned the task of DataProvider.
    public Object[] myDatas() { // The type of the method to be used as DataProvider must be Object.
        Object[] users = {"Yakup", "Kadri", "Ziya", "Osman"};
        return users;
    }
}
