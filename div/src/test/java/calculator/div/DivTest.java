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
    public void calculateNaN() {
        try {
            Div oper = new Div();
            Assert.assertEquals(Double.NaN, oper.Calculate(Double.NaN, Double.NaN), 0.001);
            Assert.assertEquals(Double.NaN, oper.Calculate(Double.NaN, 45), 0.001);
        }
        catch (Exception e){

        }

    }

    @org.junit.Test
    public void calculateZero() {
        try {
            Div oper = new Div();
            Assert.assertEquals(Double.NaN, oper.Calculate(Double.NaN, Double.NaN), 0.001);
            Assert.assertEquals(Double.NaN, oper.Calculate(Double.NaN, 45), 0.001);
        }
        catch (Exception e){
            String expectedMessage = "divison error";
            Assert.assertEquals( "исключение выброшено корректно", expectedMessage, e.getMessage() );
        }

    }

    @org.junit.Test
    public void calculateManyArg() {
        try {
            Div oper = new Div();
            Assert.assertEquals(1, oper.Calculate(45, 45, 56, 56), 0.001);
        }
        catch (Exception e){

        }

    }

    @org.junit.Test
    public void calculateOneArg() {
        try {
            Div oper = new Div();
            oper.Calculate(456);
        }
        catch (Exception e){
            String expectedMessage = "1";
            Assert.assertEquals( "исключение выброшено корректно", expectedMessage, e.getMessage() );
        }

    }

    @org.junit.Test
    public void calculateNoneArg() {
        try {
            Div oper = new Div();
            oper.Calculate();
        } catch (Exception e) {
            String expectedMessage = "0";
            Assert.assertEquals("исключение выброшено корректно", expectedMessage, e.getMessage());
        }
    }


    @org.junit.Test
    public void getArgCount() {
        Div oper = new Div();
        Assert.assertEquals(2,oper.getArgCount());
    }

    @org.junit.Test
    public void getNameArg() {
        Div oper = new Div();
        try {
            Assert.assertEquals("делимое", oper.getNameArg(0));
            Assert.assertEquals("делитель", oper.getNameArg(1));
            oper.getNameArg(45);
        }
        catch (Exception e)
        {
            String expectedMessage = "1";
            Assert.assertEquals( "Делиние", expectedMessage, e.getMessage() );
        }

    }


    @org.junit.Test
    public void getNameOp() {
        Div oper = new Div();
        Assert.assertEquals("Делиние",oper.getNameOp());

    }



}