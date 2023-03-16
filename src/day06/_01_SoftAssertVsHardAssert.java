package day06;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _01_SoftAssertVsHardAssert {

    @Test
    void hardAssert() {

        String s1 = "Hello";
        System.out.println("Before Hard Assert");
        Assert.assertEquals("Hello", s1, "Different formed with the expected.");
        System.out.println("After Hard Assert");

    }

    @Test
    void softAssert() {
        String strHomePage = "www.facebook.com/homepage";
        String strCartPage = "www.facebook.com/cartpage";
        String strEditAccount = "www.facebook.com/editaccountpage";

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals("www.facebook.com/homepage",strHomePage); // true
        System.out.println("softAssert1");
        softAssert.assertEquals("www.facebook.com/profile",strCartPage); // false
        System.out.println("softAssert2");
        softAssert.assertEquals("www.facebook.com/settings",strEditAccount); // false
        System.out.println("softAssert3");

        softAssert.assertAll(); // All assert results
        System.out.println("After activity");
        // This section will not be on the screen because it is after assertAll and a mistake before it.

    }
}
