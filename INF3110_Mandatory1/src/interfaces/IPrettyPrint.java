package interfaces;

/**
 * Makes it so that an object is only printed once.
 * 
 * Each object implementing this interface should implement
 * a boolean variable to mark if the object has been printed or not.
 * 
 * @author haavakno
 */
public interface IPrettyPrint {
    
    /**
     * Prints a object using its toString method if
     * it hasn't already been printed.
     */
    public void prettyPrint();
    
    /**
     * Marks the current object as printed.
     */
    public void setPrinted();
}
