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
    public Number getXPosition();
    public Number getYPosition();
    public Direction getDirection();

    }
