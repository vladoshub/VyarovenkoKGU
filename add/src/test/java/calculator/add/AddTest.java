package calculator.add;

import org.junit.Assert;
import org.junit.Test;


public class AddTest {

    @Test
    public void calculate() {
        try {
            Add oper = new Add();
            double a = oper.Calculate(5, 5);
            Assert.assertEquals(10, (float) a, 0.001);
            double a1 = oper.Calculate(0, 5);
            Assert.assertEquals(5, (float) a1, 0.001);
            double a2 = oper.Calculate(0, 0);
            Assert.assertEquals(0, (float) a2, 0.001);
            double b3 = oper.Calculate(-10, -4);
            Assert.assertEquals(-14, (float) b3, 0.001);
            double b4 = oper.Calculate(10, 5.5);
            Assert.assertEquals(15.5, (float) b4, 0.001);
            double b5 = oper.Calculate(-100, 5);
            Assert.assertEquals(-95, (float) b5, 0.001);
        }
        catch (Exception e){

        }
    }


    @org.junit.Test
    public void calculateNaN() {
        try {
            Add oper = new Add();
            Assert.assertEquals(Double.NaN, oper.Calculate(Double.NaN, Double.NaN), 0.001);
            Assert.assertEquals(Double.NaN, oper.Calculate(Double.NaN, 45), 0.001);
        }
        catch (Exception e){

        }

    }


    @org.junit.Test
    public void calculateManyArg() {
        try {
            Add oper = new Add();
            Assert.assertEquals(90, oper.Calculate(45, 45, 56, 56), 0.001);
        }
        catch (Exception e){

        }

    }

    @org.junit.Test
    public void calculateOneArg() {
        try {
            Add oper = new Add();
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
            Add oper = new Add();
            oper.Calculate();
        } catch (Exception e) {
            String expectedMessage = "0";
            Assert.assertEquals("исключение выброшено корректно", expectedMessage, e.getMessage());
        }
    }


    @org.junit.Test
    public void getArgCount() {
        Add oper = new Add();
        Assert.assertEquals(2,oper.getArgCount());
    }

    @org.junit.Test
    public void getNameArg() {
        Add oper = new Add();
        try {
            Assert.assertEquals("1операнд", oper.getNameArg(0));
            Assert.assertEquals("2операнд", oper.getNameArg(1));
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
        Add oper = new Add();
        Assert.assertEquals("Cложение",oper.getNameOp());

    }


    }
