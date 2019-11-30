package calculator.mul;

import org.junit.Assert;

import static org.junit.Assert.*;

public class MulTest {

    @org.junit.Test
    public void calculate() {
        Mul oper = new Mul();
        double a = oper.Calculate(5, 5);
        Assert.assertEquals(25,(float)a,0.001);
        double a1 = oper.Calculate(0, 5);
        Assert.assertEquals(0,(float)a1,0.001);
        double a2 = oper.Calculate(0, 0);
        Assert.assertEquals(0,(float)a2,0.001);
        double b3 = oper.Calculate(-10, -4);
        Assert.assertEquals(40,(float)b3,0.001);
        double b4 = oper.Calculate(11, 5.5);
        Assert.assertEquals(60.5,(float)b4,0.001);
        double b5 = oper.Calculate(100, -5);
        Assert.assertEquals(-500,(float)b5,0.001);
    }
}