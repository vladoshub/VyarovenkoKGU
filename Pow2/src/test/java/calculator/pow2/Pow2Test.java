package calculator.pow2;

import org.junit.Assert;

import java.util.Calendar;

import static org.junit.Assert.*;

public class Pow2Test {

    @org.junit.Test
    public void calculate() {

        try {
            Pow2 oper = new Pow2();
            double a = oper.Calculate(5);
            Assert.assertEquals(25, (float) a, 0.001);
            double a1 = oper.Calculate(0);
            Assert.assertEquals(0, (float) a1, 0.001);
            double a2 = oper.Calculate(-5);
            Assert.assertEquals(25, (float) a2, 0.001);
            double a3 = oper.Calculate(0.25);
            Assert.assertEquals(0.0625, (float) a3, 0.001);
        }
        catch (Exception e){

        }
    }



    @org.junit.Test
    public void calculateNaN() {
        try {
            Pow2 oper = new Pow2();
            Assert.assertEquals(Double.NaN, oper.Calculate(Double.NaN), 0.001);
        }
        catch (Exception e){

        }
    }

    @org.junit.Test
    public void calculateManyArg() {
        try {
            Pow2 oper = new Pow2();
            Assert.assertEquals(49, oper.Calculate(7, 45, 56, 56), 0.001);
        }
        catch (Exception e){

        }

    }

    @org.junit.Test
    public void calculateNoneArg() {
        try {
            Pow2 oper = new Pow2();
            oper.Calculate();
        }
        catch (Exception e){
            String expectedMessage = "0";
            Assert.assertEquals( "исключение выброшено корректно", expectedMessage, e.getMessage() );
        }

    }

    @org.junit.Test
    public void getArgCount() {
        Pow2 oper = new Pow2();
        Assert.assertEquals(1,oper.getArgCount());
    }

    @org.junit.Test
    public void getNameArg() {
        Pow2 oper = new Pow2();
        try {
            Assert.assertEquals("1операнд", oper.getNameArg(0));
            oper.getNameArg(45);
        }
        catch (Exception e)
        {
            String expectedMessage = "1";
            Assert.assertEquals( "исключение выброшено корректно", expectedMessage, e.getMessage() );
        }

    }


    @org.junit.Test
    public void getNameOp() {
        Pow2 oper = new Pow2();
        Assert.assertEquals("Возведение во 2 степень",oper.getNameOp());

    }

}