package calculator.div;

import calculator.api.Operations;

public class Div implements Operations {
    public double Calculate(double a, double b) {
        return a/b;
    }
    public String getNameOp() {
        return "Operation DIV";
    }
}
