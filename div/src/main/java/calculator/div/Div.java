package calculator.div;

import calculator.api.Operations;

public class Div implements Operations {
    public double Calculate(double... a) throws Exception{
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
        return "Operation DIV";
    }
}
