package interfaces;

/**
 * Used wherever an object only needs to manipulate a positions
 * turn/move methods, like in the Robol languages Left/Right/Forward/Backward.
 * 
 * @author haavakno
 */
public interface IPositionActions extends IPosition {
    
     /**
     * Turn left according to the current direction.
     * 
     * @throws RuntimeException
     */
    public void turnLeft();
    
    /**
     * Turn right according to the current direction.
     */
    public void turnRight();
    
    /**
     * Flip the current direction.
     */
    public void turnAround();
    
    /**
     * Moves the current position one step in its current direction.
     * 
     * @return a new position object with the updated coordinates.
     */
    public IPosition moveForward();
}
