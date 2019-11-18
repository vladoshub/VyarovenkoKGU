package calculator.userinterface;


import calculator.api.Operations;
import calculator.classloader.ExtensionLoader;

import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UserInterface implements calculator.userinterfaceapi.UserInterface {

    private List<Operations> operations =  new ArrayList<Operations>();
    private Scanner scanner = new Scanner(System.in);

    public List<Operations> getOperations() {
        return operations;
    }

    public void Out(double out) {
        System.out.println("result: "+out);
    }

    public void InitJar() {
        List<String> classNames = new ArrayList<String>();
        try{
            File dir = new File("C:/jar/"); //path указывает на директорию
            File[] arrFiles = dir.listFiles();
            for (File f:arrFiles) {
                ZipInputStream zip = new ZipInputStream(new FileInputStream(f));
                for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
                    if (!entry.isDirectory() && entry.getName().endsWith(".class")) {
                        // This ZipEntry represents a class. Now, what class does it represent?
                        String className = entry.getName().replace('/', '.'); // including ".class"
                        classNames.add(className.substring(0, className.length() - ".class".length()));
                    }
                }
            }
        }
        catch (Exception e){

        }

            ExtensionLoader<Operations> loader = new ExtensionLoader<Operations>();
            for (String s : classNames){
                try {
                    operations.add(loader.LoadClass("C:/jar/", s, Operations.class));
                }
                catch (Exception e){
                    continue;
                }
        }
    }

    public boolean ValidDivOp(double a,double b){
        if (b == 0) return false;
        return true;
    }

    public void ParseAndCalc(Operations op) {
        try {
            System.out.println("input first operand");
            double a = Double.parseDouble(scanner.nextLine());
            System.out.println("input second operand");
            double b = Double.parseDouble(scanner.nextLine());
            if(ValidDivOp(a,b))
            Out(op.Calculate(a,b));
            else
            {
                System.out.println("Reinput");
                ParseAndCalc(op);
            }
        } catch (Exception e) {
            System.out.println("Error input,reinput pls");
        }
    }


    public void ShowOps() {
        try {
            int k=0;
            System.out.println("press number to");
            for(Operations op:operations) {
                k++;
                System.out.println(k+" - "+op.getNameOp());
            }
            int type = Integer.parseInt(scanner.nextLine());
            if (type>0&&type<5){
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
