package day03;

import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseDriver;

public class _01_Dependency extends BaseDriver {
    // Vehicle movement ==> start, drive, park, stop movement sequence

    @Test
    void startCar() {
        System.out.println("startCar");
        // Assert.fail();
    }

    @Test(dependsOnMethods = {"startCar"})
        // The running of this test depends on the error-free operation of startCar.
    void driveCar() {
        System.out.println("driveCar");
    }

    @Test(dependsOnMethods = {"startCar", "driveCar"})
    void parkCar() {
        System.out.println("parkCar");
    }

    @Test(dependsOnMethods = {"parkCar"}, alwaysRun = true)
        // alwaysRun=true if there are dependencies but still run if error occurs.
    void stopCar() {
        System.out.println("stopCar");
    }

     /**
     priority can be given for tests at the same level.
     When you run the dependent tests from the direct method they can automatically call
     and run up to 1 in the method chain they are dependent on.
     */


}
