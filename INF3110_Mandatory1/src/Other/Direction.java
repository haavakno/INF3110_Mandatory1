/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

/**
 *
 * @author haavakno
 */
public enum Direction {
    
    LEFT("-x"), 
    RIGHT("x"),
    UP("y"),
    DOWN("-y");
    
    private String value;
    private Direction(String value) {
        this.value = value;
    }
    
    public static Direction getDirection(String value) {
       
        if (value.equals(LEFT.value)) {
            return LEFT;
        } else if (value.equals(RIGHT.value)) {
            return RIGHT;
        } else if (value.equals(UP.value)) {
            return UP;
        } else if (value.equals(DOWN.value)) {
            return DOWN;
        } else {
            throw new RuntimeException("Unknown direction: " + value);
        }
    }
    
    public static char getCharValue(Direction d) {
        switch (d) {
            case LEFT:
                return '<';
            case RIGHT:
                return '>';
            case UP:
                return '^';
            case DOWN:
                return 'v';
            default:
                throw new RuntimeException("Unknown direction: " + d);
        }
        
    }
}
