package calculator.div;

import calculator.api.Operations;

public class Div implements Operations {
    public double Calculate(double... a) {
        return a[0]/a[1];
    }
    public String getNameOp() {
        return "Operation DIV";
    }
}
