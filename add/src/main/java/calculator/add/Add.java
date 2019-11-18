package calculator.add;

import calculator.api.Operations;;

public class Add implements Operations {
    public double Calculate(double a,double b) {
        return a+b;
    }

    public String getNameOp() {
        return "Operation ADD";
    }

}
