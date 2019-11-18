package calculator.userinterfaceapi;

import calculator.api.Operations;

public interface UserInterface {
    public void ShowOps();
    public void InitJar();
    public void Out(double out);
    public void ParseAndCalc(Operations op);
    public boolean ValidDivOp(double a,double b);
}
