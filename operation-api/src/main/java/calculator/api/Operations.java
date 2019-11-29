package calculator.api;

public interface Operations {
     int getArgCount();
     double Calculate(double... a) throws Exception;
     String getNameOp();
     String getNameArg(int i) throws Exception;
}
