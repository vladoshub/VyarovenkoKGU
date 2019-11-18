package calculator.mul;

import calculator.api.Operations;

public class Mul implements Operations {
    public double Calculate(double a, double b) {
        return a*b;
    }

    public String getNameOp() {
        return "Operation MUL";
    }
}
