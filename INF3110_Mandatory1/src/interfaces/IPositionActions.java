/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author haavakno
 */
public interface IPositionActions extends IPosition {
    public void turnLeft();
    public void turnRight();
    public void turnAround();
    public IPosition moveForward();
}
