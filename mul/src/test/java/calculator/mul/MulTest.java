package calculator.mul;

import org.junit.Assert;

import java.util.Calendar;

import static org.junit.Assert.*;

public class MulTest {

    @org.junit.Test
    public void calculate() {
        try {
            Mul oper = new Mul();
            double a = oper.Calculate(5, 5);
            Assert.assertEquals(25, (float) a, 0.001);
            double a1 = oper.Calculate(0, 5);
            Assert.assertEquals(0, (float) a1, 0.001);
            double a2 = oper.Calculate(0, 0);
            Assert.assertEquals(0, (float) a2, 0.001);
            double b3 = oper.Calculate(-10, -4);
            Assert.assertEquals(40, (float) b3, 0.001);
            double b4 = oper.Calculate(11, 5.5);
            Assert.assertEquals(60.5, (float) b4, 0.001);
            double b5 = oper.Calculate(100, -5);
            Assert.assertEquals(-500, (float) b5, 0.001);
        } catch (Exception e) {

        }
    }

    @org.junit.Test
    public void calculateNaN() {
        try {
            Mul oper = new Mul();
            Assert.assertEquals(Double.NaN, oper.Calculate(Double.NaN, Double.NaN), 0.001);
            Assert.assertEquals(Double.NaN, oper.Calculate(Double.NaN, 45), 0.001);
        }
        catch (Exception e){

        }

    }

    @org.junit.Test
    public void calculateManyArg() {
        try {
            Mul oper = new Mul();
            Assert.assertEquals(45, oper.Calculate(1, 45, 56, 56), 0.001);
        }
        catch (Exception e){

        }

    }

    @org.junit.Test
    public void calculateOneArg() {
        try {
            Mul oper = new Mul();
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
            Mul oper = new Mul();
            oper.Calculate();
        } catch (Exception e) {
            String expectedMessage = "0";
            Assert.assertEquals("исключение выброшено корректно", expectedMessage, e.getMessage());
        }
    }


        @org.junit.Test
    public void getArgCount() {
        Mul oper = new Mul();
        Assert.assertEquals(2,oper.getArgCount());
    }

    @org.junit.Test
    public void getNameArg() {
        Mul oper = new Mul();
        try {
            Assert.assertEquals("1 множитель", oper.getNameArg(0));
            Assert.assertEquals("2 множитель", oper.getNameArg(1));
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
        Mul oper = new Mul();
        Assert.assertEquals("Умножение",oper.getNameOp());

    }

}