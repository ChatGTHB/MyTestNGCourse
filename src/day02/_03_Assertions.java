package day02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_Assertions {

    @Test
    void equalsExample() {

        String s1 = "Hello";
        String s2 = "Hello";

        // Actual(Oluşan),Expected(Umulan),Message(Optional)
        Assert.assertEquals(s1, s2, "Oluşan ve umulan eşleşmedi.");
    }

    @Test
    void notEqualsExample() {

        String s1 = "Hello";
        String s2 = "Hello1";

        // Actual(Oluşan),Expected(Umulan),Message(Optional)
        Assert.assertNotEquals(s1, s2, "Oluşan ve umulan eşleşti.");
    }

    @Test
    void trueExample() {

        int s1 = 55;
        int s2 = 66;

        // Actual(Oluşan),Expected(Umulan),Message(Optional)
        Assert.assertTrue(s1 == s2, "Karşılaştırılanlar eşit değil");
    }

    @Test
    void nullExample() {

        String s1 = null;

        Assert.assertNull(s1, "Null değil");
    }

    @Test
    void directFail() {

        int num=55;
        if(num==55){
            Assert.fail(); // Assert.fail("Hata oluştu.")
        }
    }

}


