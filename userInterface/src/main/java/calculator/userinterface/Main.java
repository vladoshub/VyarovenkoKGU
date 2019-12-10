package calculator.userinterface;

public class Main {
    public static void main(String[] args){
        UserInterface userInterface = new UserInterface("C:/jar/");
        userInterface.InitJar();
        if(!userInterface.getOperations().isEmpty())
            new Frame();
        else {
            System.out.println("jar not found or jar not include implement class");
        }
    }


}
