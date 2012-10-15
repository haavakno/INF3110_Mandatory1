package expression;

/**
 * The Robol Number.
 * 
 * @author haavakno
 */
public class Number extends Expression {
    
    private final int value;
    
    /**
     * Create a number from an integer.
     * 
     * @param value to be stored.
     */
    public Number(int value) {
        this.value = value;
    }
    
    /**
     * Create a number form another number.
     *  
     * @param number to be created from.
     */
    public Number(Number number) {
        this.value = number.getValue();
    }

    /**
     * Return this numbers representation.
     * 
     * @return integer.
     */
    @Override
    public int getValue() {
        return this.value;
    }
    
    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
