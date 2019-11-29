package calculator.mul;

import org.junit.Assert;

import static org.junit.Assert.*;

public class MulTest {

    @org.junit.Test
    public void calculate() {
        Mul mul = new Mul();
        double a1 = mul.Calculate(5, 5);
        double b1 = mul.Calculate(1, 25);
        double a2 = mul.Calculate(2, 10);
        double b2 = mul.Calculate(4, 5);
        Assert.assertEquals((float)a1,(float)b1,0.001);
        Assert.assertEquals((float)a2,(float)b2,0.001);
    }
}