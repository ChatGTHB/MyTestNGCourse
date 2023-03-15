package day03;

import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseDriver;

public class _01_Dependency extends BaseDriver {
    // Aracın hareketi ==> start, drive, park, stop hareket sıras

    @Test
    void startCar() {
        System.out.println("startCar");
        // Assert.fail();
    }
    @Test(dependsOnMethods = {"startCar"})
        // Bu testin çalışması, startCar'ın hatasız çalışmasına bağlı
    void driveCar() {
        System.out.println("driveCar");
    }

    @Test(dependsOnMethods = {"startCar", "driveCar"})
    void parkCar() {
        System.out.println("parkCar");
    }

    // alwaysRun=true bağımlılıkarı olmasına rağmen hata çıkarsa yine de çalıştır.
    @Test(dependsOnMethods = {"parkCar"}, alwaysRun = true)
    void stopCar() {
        System.out.println("stopCar");
    }

    // aynı seviyedeki testleri için priority verilebilir.
    // bağımlı testler, direk metodundan çalıştırdığınızda bağımlı olduğu metod zincirinde
    // 1 üste kadar ototmatik çağırıp çalışabilir.
}
