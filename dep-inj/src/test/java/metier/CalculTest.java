package metier;

import org.junit.Assert;
import org.junit.Test;

public class CalculTest {
    @Test
    public void calculTest(){
        int a=15,b=5;
        Assert.assertEquals(20,Calcul.somme(a,b));
    }
}
