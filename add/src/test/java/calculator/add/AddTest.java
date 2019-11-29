package calculator.add;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddTest {

    @Test
    public void calculate() {
        Add add = new Add();
        double a=add.Calculate(5,4);
        double b=add.Calculate(2,7);
        Assert.assertEquals((float)a,(float)b,0.001);
    }

}