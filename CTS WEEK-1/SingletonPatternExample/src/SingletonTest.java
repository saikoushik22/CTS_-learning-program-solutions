public class SingletonTest {

    public static void main(String[] args) {

        
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        System.out.println("logger1 == logger2 ? " + (logger1 == logger2));  // true

        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");
    }
}
