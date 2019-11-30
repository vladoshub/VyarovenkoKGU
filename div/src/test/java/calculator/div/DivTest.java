package calculator.div;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DivTest {

    @org.junit.Test
    public void calculate() {
        Div oper = new Div();
        try {
            double a = oper.Calculate(5, 5);
            double b = oper.Calculate(-87, -87);
            Assert.assertEquals((float)a,(float)b,0.001);
            double a1 = oper.Calculate(0, 5);
            double b1 = oper.Calculate(0, 87);
            Assert.assertEquals((float)a1,(float)b1,0.001);
            double a2 = oper.Calculate(0, 0);
            double b2 = oper.Calculate(0, 0);
            Assert.assertEquals((float)a2,(float)b2,0.001);
            double b3 = oper.Calculate(-10, -4);
            Assert.assertEquals(2.5,(float)b3,0.001);
            double b4 = oper.Calculate(11, 5.5);
            Assert.assertEquals(2,(float)b4,0.001);
            double b5 = oper.Calculate(100, -5);
            Assert.assertEquals(-20,(float)b5,0.001);
        }
        catch (Exception e){

        }

    }


    @org.junit.Test
    public void getNameArg() {

    }

}