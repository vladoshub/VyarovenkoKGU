package calculator.subtraction;

import org.junit.Assert;

import static org.junit.Assert.*;

public class SubtractionTest {

    @org.junit.Test
    public void calculate() {

        try {
            Subtraction oper = new Subtraction();
            double a = oper.Calculate(5, 5);
            Assert.assertEquals(0, (float) a, 0.001);
            double a1 = oper.Calculate(0, 5);
            Assert.assertEquals(-5, (float) a1, 0.001);
            double a2 = oper.Calculate(0, 0);
            Assert.assertEquals(0, (float) a2, 0.001);
            double b3 = oper.Calculate(-10, -4);
            Assert.assertEquals(-6, (float) b3, 0.001);
            double b4 = oper.Calculate(11, 5.5);
            Assert.assertEquals(5.5, (float) b4, 0.001);
            double b5 = oper.Calculate(100, -5);
            Assert.assertEquals(105, (float) b5, 0.001);
        }
        catch (Exception e){

        }
    }



    @org.junit.Test
    public void calculateNaN() {
        try {
            Subtraction oper = new Subtraction();
            Assert.assertEquals(Double.NaN, oper.Calculate(Double.NaN, Double.NaN), 0.001);
        }
        catch (Exception e){

        }
    }

    @org.junit.Test
    public void calculateManyArg() {
        try {
            Subtraction oper = new Subtraction();
            Assert.assertEquals(0, oper.Calculate(49, 49, 56, 56), 0.001);
        }
        catch (Exception e){

        }

    }

    @org.junit.Test
    public void calculateOneArg() {
        try {
            Subtraction oper = new Subtraction();
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
            Subtraction oper = new Subtraction();
            oper.Calculate();
        }
        catch (Exception e){
            String expectedMessage = "0";
            Assert.assertEquals( "исключение выброшено корректно", expectedMessage, e.getMessage() );
        }

    }

    @org.junit.Test
    public void getArgCount() {
        Subtraction oper = new Subtraction();
        Assert.assertEquals(2,oper.getArgCount());
    }

    @org.junit.Test
    public void getNameArg() {
        Subtraction oper = new Subtraction();
        try {
            Assert.assertEquals("1операнд", oper.getNameArg(0));
            Assert.assertEquals("2операнд", oper.getNameArg(1));
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
        Subtraction oper = new Subtraction();
        Assert.assertEquals("Разность",oper.getNameOp());

    }
}