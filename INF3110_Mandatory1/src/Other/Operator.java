package Other;

/**
 *
 * @author haavakno
 */
public enum Operator {
    
    /**
     * Enum of robols add symbol.
     */
    ADD("+"),
    /**
     * Enum of robols subtract symbol.
     */
    SUBTRACT("-"),
    /**
     * Enum of robols multiply symbol.
     */
    MULTIPLY("*"),
    /**
     * Enum of robols less than symbol.
     */
    LESS("<"),
    /**
     * Enum of robols greater than symbol.
     */
    GREATER(">"),
    /**
     * Enum of robols equal symbol.
     */
    EQUAL("=");
    
    private String value;
    private Operator(String value) {
        this.value = value;
    }
    
    /**
     * Returns the operator associated with the given value.
     * 
     * @param value - value of an operator.
     * @return the operator of the associated value.
     * @throws RuntimeException
     */
    public static Operator getOperator(String value) {
        for (Operator op : Operator.values()) {
            if (op.value.equals(value)) {
                return op;
            }
        }
        throw new RuntimeException("Unknown operator: " + value);
    }
    
    @Override
    public String toString() {
        return this.value;
    }
}
