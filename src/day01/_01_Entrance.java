package day01;

import org.testng.annotations.Test;

public class _01_Entrance {

    //If any ranking is not given, the names of the methods work alphabetical.
    @Test(priority = 1)
    public void openDriver() {
        System.out.println("The driver was defined and the website was opened.");
    }

    @Test(priority = 2)
    public void logIn() {
        System.out.println("Logintest was performed.");
    }

    @Test(priority = 3)
    public void closeDriver() {
        System.out.println("The driver was closed.");

    }
}

