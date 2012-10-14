/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Other.Direction;

/**
 *
 * @author haavakno
 */
public interface IGrid extends Handler {
    public void setRobot(IRobot robot);
    public boolean legalMove(IPosition position);
}
