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
    
    LEFT("-x", '<'), 
    RIGHT("x", '>'),
    UP("y", '^'),
    DOWN("-y", 'v');
    
    private String value;
    private char charValue;
    
    private Direction(String value, char charValue) {
        this.value = value;
        this.charValue = charValue;
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
        for (Direction dir : Direction.values()) {
            if (dir == d) {
                return dir.charValue;
            }
        }
        throw new RuntimeException("Unknown direction: " + d);
    }
}
