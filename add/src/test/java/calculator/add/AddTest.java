package calculator.add;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddTest {

    @Test
    public void calculate() {
        Add oper = new Add();
        double a = oper.Calculate(5, 5);
        Assert.assertEquals(10,(float)a,0.001);
        double a1 = oper.Calculate(0, 5);
        Assert.assertEquals(5,(float)a1,0.001);
        double a2 = oper.Calculate(0, 0);
        Assert.assertEquals(0,(float)a2,0.001);
        double b3 = oper.Calculate(-10, -4);
        Assert.assertEquals(-14,(float)b3,0.001);
        double b4 = oper.Calculate(11, 5.5);
        Assert.assertEquals(15.5,(float)b4,0.001);
        double b5 = oper.Calculate(100, -5);
        Assert.assertEquals(-95,(float)b5,0.001);
    }



}