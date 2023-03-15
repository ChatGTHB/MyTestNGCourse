package day04;

import org.testng.annotations.*;

public class _01_Intro {

   /*
     @BeforeSuite
       @BeforeTest
         @BeforeGroup
           @BeforeClass
             @BeforeMethod
                 @Test1 method
                 @Test2 method
             @AfterMethod
           @AfterClass
         @AfterGroup
       @AfterTest
     @AfterSuite
   */

    @BeforeSuite
    void beforeSuite() {System.out.println("Before Suite");}
    @BeforeTest
    void beforeTest() {System.out.println("Before Test");}
    @BeforeGroups
    void beforeGroups() {System.out.println("Before Groups");}
    @BeforeClass
    void beforeClass(){System.out.println("Before Class");}
    @BeforeMethod
    void beforeMethod(){System.out.println("Before Method");}
    @Test
    void Intro1_Test1(){System.out.println("Intro_1 -> Test 1");}
    @Test
    void Intro1_Test2(){System.out.println("Intro_1 -> Test 2");}
    @AfterMethod
    void afterMethod(){System.out.println("After Method");}
    @AfterClass
    void afterClass(){System.out.println("After Class");}
    @AfterGroups
    void afterGroups() {System.out.println("After Groups");}
    @AfterTest
    void afterTest() {System.out.println("After Test");}
    @AfterSuite
    void afterSuite() {System.out.println("After Suite");}

}


