package calculator.mul;

import calculator.api.Operations;

public class Mul implements Operations {
    public double Calculate(double... a) {
        return a[0]*a[1];
    }

    public String getNameOp() {
        return "Operation MUL";
    }
}
