package log;

/**
 * Used to log variable messages.
 * 
 * Currently only used to print out a robots start position and
 * when the robot moves, prints out the from and to positions.
 * 
 * @author haavakno
 */
public class Log {
    
    private static boolean log = false;
    
    /**
     * Prints out a string with linespace if log is true.
     * 
     * @param msg to be printed.
     */
    public static void logln(String msg) {
        if (log) {
            System.out.println(msg);
        }
    }
    
    /**
     * Prints out a string without linespace if log is true.
     * 
     * @param msg to be printed.
     */
    public static void log(String msg) {
        if (log) {
            System.out.print(msg);
        }
    }
}
