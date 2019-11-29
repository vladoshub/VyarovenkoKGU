package calculator.div;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import org.junit.Assert;

import static org.junit.Assert.*;

public class DivTest {

    @org.junit.Test
    public void calculate() {
        Div div = new Div();
        try {
            double a = div.Calculate(5, 5);
            double b = div.Calculate(87, 87);
            Assert.assertEquals((float)a,(float)b,0.001);
        }
        catch (Exception e){

        }

    }

}