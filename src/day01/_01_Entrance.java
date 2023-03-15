package day01;

import org.testng.annotations.Test;

public class _01_Entrance {

    // Eğer herhangi bir sıralama verilmezse metod isimlerinin alfabetik çalışıyor
    @Test(priority = 1)
    public void openDriver() {
        System.out.println("Driver tanımlandı ve web sitesi açıldı.");
    }
    @Test(priority = 2)
    public void logIn() {
        System.out.println("LoginTest işlemi yapıldı.");
    }

    @Test(priority = 3)
    public void closeDriver() {
        System.out.println("Driver kapatıldı.");

    }
}

