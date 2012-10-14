/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import interfaces.IPosition;
import expression.Number;
import interfaces.IPositionActions;

/**
 *
 * @author haavakno
 */
public class Position implements IPosition, IPositionActions {

    public static IPositionActions updatePosition(IPosition position, int x, int y) {
        return new Position(x + position.getXPosition().getValue(), 
                y + position.getYPosition().getValue(), 
                position.getDirection());
    }

    private Number xPosition;
    private Number yPosition;
    private Direction direction;
    
    private Position(int x, int y, Direction direction) {
        this.xPosition = new Number(x);
        this.yPosition = new Number(y);
        this.direction = direction;
    }
    
    public Position(Number xPosition, Number yPosition, Direction direction) {
        this.xPosition = new Number(xPosition);
        this.yPosition = new Number(yPosition);
        this.direction = direction;
    }
    
    public Position(Position position) {
        this.xPosition = position.getXPosition();
        this.yPosition = position.getYPosition();
        this.direction = position.getDirection();
    }
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

    @Override
    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    @Override
    public void turnAround() {
        turnLeft();
        turnLeft();
    }

    @Override
    public Number getXPosition() {
        return new Number(this.xPosition);
    }

    @Override
    public Number getYPosition() {
        return new Number(this.yPosition);
    }

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

    @Override
    public Direction getDirection() {
        return this.direction;
    }

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
