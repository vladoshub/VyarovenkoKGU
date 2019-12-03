package calculator.div;

import calculator.api.Operations;

public class Div implements Operations {
    public double Calculate(double... a) throws Exception{
        if(a.length==0)
            throw new Exception("0");
        if(a.length==1)
            throw new Exception("1");
        if (a[1]!=0)
        return a[0]/a[1];
        else {
            throw new Exception("divison error");
        }
    }


    @Override
    public int getArgCount() {
        return 2;
    }

    @Override
    public String getNameArg(int i) throws Exception {
        switch (i){
            case 0:return "делимое";
            case 1:return "делитель";
            default: throw  new Exception("1");

        }

    }

    public String getNameOp() {
        return "Делиние";
    }
}
