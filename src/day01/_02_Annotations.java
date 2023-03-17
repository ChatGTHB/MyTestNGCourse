package day01;

import org.testng.annotations.*;

public class _02_Annotations {

    /**
       @Beforeclass        --> will work at the beginning of class (driver operations)
            @Beforemethod  --> will work first from each method (test methods)
                @Test      --> methods where tests work
                @Test      --> methods where tests work
            @Ftermethod    --> will work after every method
         @AfferClass       --> will work at the end of the work of class (driver off)
     */
    @BeforeClass
    public void beforeClass() {
        System.out.println("beforeClass ran.");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("afterClass ran.");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod ran.");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod ran.");
    }

    @Test
    public void test1() {
        System.out.println("test1 ran.");
    }

    @Test
    public void test2() {
        System.out.println("test2 ran.");
    }
}
