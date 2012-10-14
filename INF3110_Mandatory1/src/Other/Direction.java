/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import java.util.Collection;
import java.util.LinkedList;

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
    private char charValue;
    
    private Direction(String value) {
        this.value = value;
    }
    
    public static Direction getDirection(String value) {
       for (Direction d : Direction.values()) {
           if (d.value.equals(value)) {
               return d;
           }
       }
       throw new RuntimeException("Unknown direction: " + value);
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
    
    public String toString() {
        return this.value;
    }
}
