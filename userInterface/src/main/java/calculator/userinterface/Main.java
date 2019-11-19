package calculator.userinterface;

public class Main {
    public static void main(String[] args){
        UserInterface userInterface = new UserInterface();
        userInterface.InitJar();
        if(!userInterface.getOperations().isEmpty())
        userInterface.ShowOps();
        else {
            System.out.println("jar not found or jar not include implemet class");
        }
    }

}
