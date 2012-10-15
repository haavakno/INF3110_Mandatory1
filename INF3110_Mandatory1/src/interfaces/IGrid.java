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
    
    /**
     * Set a grids robot.
     * 
     * @param robot to be added to this grid.
     */
    public void setRobot(IRobot robot);
    
    /**
     * Checks if a position is inside the grid.
     * 
     * @param position to be checked
     * @return true if position is inside the grid.
     *         false if position is outside the grid.
     */
    public boolean legalMove(IPosition position);
}
