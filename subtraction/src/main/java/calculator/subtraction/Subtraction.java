package calculator.subtraction;

import calculator.api.Operations;

public class Subtraction implements Operations {
    public double Calculate(double... a) throws Exception{
        if(a.length==0)
            throw new Exception("0");
        if(a.length==1)
            throw new Exception("1");
        return a[0]-a[1];
    }

    @Override
    public int getArgCount() {
        return 2;
    }

    @Override
    public String getNameArg(int i) throws Exception{
        switch (i){
            case 0:return "1операнд";
            case 1:return "2операнд";
            default:throw new Exception("1");

        }

    }

    public String getNameOp() {
        return "Разность";
    }

}
