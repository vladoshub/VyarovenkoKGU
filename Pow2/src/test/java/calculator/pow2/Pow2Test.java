package calculator.pow2;

import org.junit.Assert;

import static org.junit.Assert.*;

public class Pow2Test {

    @org.junit.Test
    public void calculate() {

        Pow2 oper = new Pow2();
        double a = oper.Calculate(5);
        Assert.assertEquals(25,(float)a,0.001);
        double a1 = oper.Calculate(0);
        Assert.assertEquals(0,(float)a1,0.001);
        double a2 = oper.Calculate(-5);
        Assert.assertEquals(25,(float)a2,0.001);
        double a3 = oper.Calculate(0.25);
        Assert.assertEquals(0.0625,(float)a3,0.001);
    }

    @org.junit.Test
    public void getNameArg() {
    }
}