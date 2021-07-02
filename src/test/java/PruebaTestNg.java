import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

public class PruebaTestNg {
    private boolean control;

    @BeforeClass
    public void beforeClass(){
    }

    @BeforeMethod
    public void beforeTest(){
    }

    @Test
    public void probarNumeroPositivo(){
        control = numIsPositivo(5);
        Assert.assertTrue(control);
    }

    @Test
    public void probarNumeroNegativo(){
        control = numIsPositivo(-5);
        Assert.assertFalse(control);
    }

    @Test
    public void probarNumeroIgualZero(){
        control = numIsPositivo(0);
        Assert.assertTrue(control, "Se esperaba que con 0 devuelva sea Positivo");
    }

    @AfterMethod
    public void afterTest(){

    }

    @AfterClass
    public void afterClass(){

    }

    public boolean numIsPositivo(int number){
        ///Cero se considera true
        if(number >= 0)
            return true;
        else
            return false;
    }
}
