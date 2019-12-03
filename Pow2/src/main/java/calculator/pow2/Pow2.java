package calculator.pow2;

import calculator.api.Operations;

public class Pow2 implements Operations {

    public double Calculate(double... a)throws Exception {
        if(a.length==0)
            throw new Exception("0");
        return Math.pow(a[0],2);
    }

    @Override
    public int getArgCount() {
        return 1;
    }

    @Override
    public String getNameArg(int i) throws Exception{
        switch (i){
            case 0:return "1операнд";
            default:throw new Exception("1");

        }

    }

    public String getNameOp() {
        return "Возведение во 2 степень";
    }

}
