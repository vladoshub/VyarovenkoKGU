package calculator.subtraction;

import calculator.api.Operations;

public class Subtraction implements Operations {
    public double Calculate(double... a) {
        return a[0]-a[1];
    }

    public String getNameOp() {
        return "Operation SUBTRACTION";
    }

}
