package Hanged.Man.Utility;

public class Logger {

    private final String reset = "[0m";

    public Logger() {}

    public void red(String x){
        System.out.println((char)27 + "[1;31m" + x + (char)27 + reset);
    };

    public void yellow(String x){
        System.out.println((char)27 + "[33m" + x + (char)27 + reset);
    };

    public void green(String x){
        System.out.println((char)27 + "[1;32m" + x + (char)27 + reset);
    };

}
