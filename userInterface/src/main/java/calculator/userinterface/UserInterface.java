package calculator.userinterface;


import calculator.api.Operations;
import calculator.classloader.ClassFinder;
import calculator.classloader.ExtensionLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface implements calculator.userinterfaceapi.UserInterface {

    private String path;
    private List<Operations> operations =  new ArrayList<Operations>();
    private Scanner scanner = new Scanner(System.in);

    public List<Operations> getOperations() {
        return operations;
    }

   public UserInterface(String path){
        this.path=path;
   }

    public void Out(double out) {
        System.out.println("result: "+out);
    }

    public void InitJar() {
        ExtensionLoader<Operations> loader = new ExtensionLoader<Operations>();//загрузчик классов
        ClassFinder classFinder = new ClassFinder(path);//ищет все классы во всех jar по пути
            for (String clazz : classFinder.getClassNames()){
                try {
                    operations.add(loader.LoadClass(path, clazz, Operations.class));//добавялем класс если он реализует Operations
                }
                catch (Exception e){
                    continue;
                }
        }
    }

    public boolean ValidDivOp(double a,double b){
        return (b == 0);
    }

    public void ParseAndCalc(Operations op) {
        try {
            System.out.println("input to view operands");
            int ops = Integer.parseInt(scanner.nextLine());
            System.out.println(op.getNameArg(ops));
            System.out.println("input first operand");
            double a = Double.parseDouble(scanner.nextLine());
            if (op.getArgCount()>1) {
                System.out.println("input second operand");
                double b = Double.parseDouble(scanner.nextLine());
                Out(op.Calculate(a, b));
            }
            else
                Out(op.Calculate(a));
        } catch (Exception e) {
            if (e.getMessage().equals("0")) {
                System.out.println("division error");
                ParseAndCalc(op);
            }
            else if(e.getMessage().equals("1")){
                System.out.println("not found this oper");
                ParseAndCalc(op);
            }
            else {
                System.out.println("Error input,reinput pls");
                ParseAndCalc(op);
            }
        }
    }


    public void ShowOps() {
        try {
            int k=0;
            System.out.println("press number to:");
            for(Operations op:operations) {
                k++;
                System.out.println(k+" - "+op.getNameOp());
            }
            int type = Integer.parseInt(scanner.nextLine());
            if (type>0&&type<=operations.size()){
                ParseAndCalc(operations.get(type-1));
            }
            else {
                System.out.println("not found this operation");
                ShowOps();
            }
        }
        catch (Exception e){
            System.out.println("Input error");
            ShowOps();
        }
    }


}
