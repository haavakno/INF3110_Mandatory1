package interfaces;

import Other.Direction;
import expression.Number;

/**
 * Implemented by the Robol statements.
 * 
 * @author haavakno
 */
public interface IRobotActions extends Handler {
    
    /**
     * Moves the robot backward.
     * 
     * @param number of steps to move robot.
     */
    public void moveBackward(Number number);
    
    /**
     * Moves the robot forward.
     * 
     * @param number of steps to move robot.
     */
    public void moveForward(Number number);
    
    /**
     * Moves the robot to the right.
     * 
     * @param number of steps to move robot.
     */
    public void moveRight(Number number);
    
    /**
     * Moves the robot to the left.
     * 
     * @param number of steps to move robot.
     */
    public void moveLeft(Number number);
    
    /**
     * Lowers the robots pen.
     * 
     * The positions where a robot moved with its pen lowered are
     * printed in the grid.
     */
    public void penDown();
    
    /**
     * Raises the robots pen.
     */
    public void penUp();
    
    /**
     * Adds a start position to the robot.
     * 
     * @param x coordinate.
     * @param y coordinate.
     * @param dir direction.
     */
    public void start(Number x, Number y, Direction dir);
    
    /**
     * Stops the robot and prints out its position.
     */
    public void stop();
}
