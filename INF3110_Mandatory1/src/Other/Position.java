package Other;

import expression.Number;
import interfaces.IPosition;
import interfaces.IPositionActions;

/**
 * Used to store a position, a position contains an x and y coordinate and
 * a direction.
 * 
 * @author haavakno
 */
public class Position implements IPosition, IPositionActions {

    private Number xPosition;
    private Number yPosition;
    private Direction direction;
    
    private Position(int x, int y, Direction direction) {
        this.xPosition = new Number(x);
        this.yPosition = new Number(y);
        this.direction = direction;
    }
    
    /**
     *Creates a position object with Robol language values.
     * 
     * @param xPosition x coordinate of this position.
     * @param yPosition y coordinate of this position.
     * @param direction of this position.
     */
    public Position(Number xPosition, Number yPosition, Direction direction) {
        this.xPosition = new Number(xPosition);
        this.yPosition = new Number(yPosition);
        this.direction = direction;
    }
    
    /**
     * Creates a position object from another position object.
     * 
     * @param position object with values for the new position.
     */
    public Position(Position position) {
        this.xPosition = position.getXPosition();
        this.yPosition = position.getYPosition();
        this.direction = position.getDirection();
    }
    
    /**
     * Returns a new position object with updated coordinates.
     * 
     * @param position object with coordinates to be updated.
     * @param x value to subtract/add from objects x coordinate.
     * @param y value to subtract/add from objects y coordinate.
     * @return a new position object with updated coordinates.
     */
    public static IPositionActions updatePosition(IPosition position, int x, int y) {
        return new Position(x + position.getXPosition().getValue(), 
                y + position.getYPosition().getValue(), 
                position.getDirection());
    }
    
    /**
     * @see interfaces.IPositionActions
     */
    @Override
    public void turnLeft() {
        switch (direction) {
            case LEFT:
                direction = Direction.DOWN;
                break;
            case RIGHT:
                direction = Direction.UP;
                break;
            case UP:
                direction = Direction.LEFT;
                break;
            case DOWN:
                direction = direction.RIGHT;
                break;
            default:
                throw new RuntimeException("Unknown direction: " + direction);
        }
    }

    /**
     * @see interfaces.IPositionActions
     */
    @Override
    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    /**
     * @see interfaces.IPositionActions
     */
    @Override
    public void turnAround() {
        turnLeft();
        turnLeft();
    }

    /**
     * @see interfaces.IPosition
     */
    @Override
    public Number getXPosition() {
        return new Number(this.xPosition);
    }

    /**
     * @see interfaces.IPosition
     */
    @Override
    public Number getYPosition() {
        return new Number(this.yPosition);
    }

    /**
     * @see interfaces.IPositionActions
     */
    @Override
    public IPosition moveForward() {
        
        int xValue = this.xPosition.getValue();
        int yValue = this.yPosition.getValue();
        
        switch (direction) {
            case LEFT:
                this.xPosition = new Number(xValue - 1);
                break;
            case RIGHT:
                this.xPosition = new Number(xValue + 1);
                break;
            case DOWN:
                this.yPosition = new Number(yValue - 1);
                break;                
            case UP:
                this.yPosition = new Number(yValue + 1);
                break;
            default:
                throw new RuntimeException("Unknown direction: " + direction);
        }
        
        return new Position(this);
    }    

    /**
     * @see interfaces.IPosition
     */
    @Override
    public Direction getDirection() {
        return this.direction;
    }

   /**
    * Compares two position objects.
    * 
    * @param o the position to be compared to the current.
    * @return -1 if the Y position differs.
    *          1 if the Y position is equal but the x position differs.
    *          0 if both x and y position are equal.
    */
    @Override
    public int compareTo(IPosition o) {
        
        if (this.getYPosition().getValue() != o.getYPosition().getValue()) {
            return -1;
        } else if (this.getXPosition().getValue() != o.getXPosition().getValue()) {
            return 1;
        } else {
            return 0;
        }
    }
    
    @Override
    public String toString() {
        return this.getXPosition() + "," + this.getYPosition() + "," + this.getDirection();
    }
}
