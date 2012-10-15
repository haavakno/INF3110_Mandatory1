/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Other.Direction;
import expression.Number;

/**
 *
 * @author haavakno
 */
public interface IPosition extends Comparable<IPosition> {
    
    /**
     * Returns the x coordinate.
     * 
     * @return x coordinate of this object.
     */
    public Number getXPosition();
    
    /**
     * Returns the y coordinate.
     * 
     * @return y coordinate of this object.
     */
    public Number getYPosition();
    
    /**
     * Returns the direction of this Object.
     * 
     * @return the direction of this object.
     */
    public Direction getDirection();

    }
