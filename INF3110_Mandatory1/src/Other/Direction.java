package Other;

/**
 * An enum for the four directions: Left, Right, Up, Down.
 * Each enum contains a value and a charValue, the value is the corresponding 
 * sign of the given value in the Robol language. The charValue is how the
 * direction is displayed when the grid is printed out.
 * 
 * @author haavakno
 */
public enum Direction {
    
    /**
     * Enum of robols left direction symbol.
     */
    LEFT("-x", '<'), 
    /**
     * Enum of robols right direction symbol.
     */
    RIGHT("x", '>'),
    /**
     * Enum of robols up direction symbol.
     */
    UP("y", '^'),
    /**
     * Enum of robols down direction symbol.
     */
    DOWN("-y", 'V');
    
    private final String value;
    private final char   charValue;
    
    private Direction(String value, char charValue) {
        this.value = value;
        this.charValue = charValue;
    }
    
    /**
     * Returns the direction with the given value.
     * 
     * @param value - value of direction to be returned.
     * @return a direction enum
     * @throws RuntimeException
     */
    public static Direction getDirection(String value) {
       for (Direction d : Direction.values()) {
           if (d.value.equals(value)) {
               return d;
           }
       }
       throw new RuntimeException("Unknown direction: " + value);
    }
    
    /**
     * Returns the character value of a given direction.
     * 
     * @param d - direction to return char value from
     * @return a character value of the given direction
     */
    public static char getCharValue(Direction d) {
        return d.charValue;
    }
    
    @Override
    public String toString() {
        return this.value;
    }
}
