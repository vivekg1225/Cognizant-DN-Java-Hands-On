package Module_1_Design_Patterns_and_Principles.Exercise_1;

public class SingletonPatternExample {
    public static void main(String[] args){
        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();

        if (l1 == l2){
            System.out.print("\nResult of l1 == l2 : ");
            System.out.print("Both point to the same address, hence only one instance is created");
        } else {
            System.out.println("Multiple instances are created");
        }
    }
}

class Logger{
    private static Logger instance;

    private Logger(){
        System.out.println("Instance created!!");
    }

    public static Logger getInstance(){
        if (instance == null){
            instance = new Logger();
        } else {
            System.out.println("Instance is already created");
        }

        return instance;
    }
}
