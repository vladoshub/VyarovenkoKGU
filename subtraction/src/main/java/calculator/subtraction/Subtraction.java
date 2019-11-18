package calculator.subtraction;

import calculator.api.Operations;

public class Subtraction implements Operations {
    public double Calculate(double a, double b) {
        return a-b;
    }

    public String getNameOp() {
        return "Operation SUBSTRACTION";
    }

}
