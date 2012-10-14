/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import Other.Direction;
import Other.Position;
import Other.VarDecl;
import expression.Identifier;
import interfaces.Handler;
import interfaces.IGrid;
import interfaces.IPosition;
import interfaces.IPrettyPrint;
import interfaces.IRobot;
import interfaces.IStatement;
import expression.Number;
import interfaces.IPositionActions;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import log.Log;

/**
 *
 * @author haavakno
 */
public class Robot implements IRobot {

    public final static Map<Identifier, VarDecl> globalVariableDeclarations = new HashMap<Identifier, VarDecl>();

    private IGrid grid;
    private IPositionActions position = null;
    private boolean penDown = false;

    private Collection<IPosition> positions = new LinkedList<IPosition>();
    
    @Override
    public void interpret() {
        for (Handler statement : statementList) {
            statement.interpret();
        }
    }

    @Override
    public void moveBackward(Number number) {
        this.position.turnAround();
        this.moveForward(number);
    }

    @Override
    public void moveForward(Number number) {

        Log.log("Robot: Moving from (" + this.position + ") ");
        // Draw current position if penDown
        setPosition(this.position);
        IPositionActions position;
        for (int i = 1; i <= number.getValue(); ++i) {
            
            int x = 0;//this.position.getXPosition().getValue();
            int y = 0;//this.position.getYPosition().getValue();
            
            switch (this.position.getDirection()) {
                case LEFT:
                    x--;
                    break;
                case RIGHT:
                    x++;
                    break;
                case UP:
                    y++;
                    break;
                case DOWN:
                    y--;
                    break;
                default:
                    throw new RuntimeException("Unknown direction: " + this.position.getDirection());
            }
            
            position = Position.updatePosition((IPosition)this.position, x, y);
            if (grid.legalMove(position)) {
                this.setPosition(position);
            } else {
                break;
            }
            
        }
        
        Log.logln("to (" + this.position + ")");
    }
    
    private void setPosition(IPositionActions position) {
        this.position = position;
        if (penDown) {
            this.positions.add(position);
        }
    }
    
    @Override
    public void setStartPosition(Number xBounds, Number yBounds, Direction direction) {
        IPositionActions position = new Position(xBounds, yBounds, direction);
        if (grid.legalMove(position)) {
            this.position = position;
            positions.add(position);
        } else {
            throw new RuntimeException("Start position outside of grid: " + position);
        }
        Log.logln("Robot: Starting at (" + position + ")");

    }

    @Override
    public void moveRight(Number number) {
        this.position.turnRight();
        this.moveForward(number);
    }

    @Override
    public void moveLeft(Number number) {
        this.position.turnLeft();
        this.moveForward(number);
    }

    @Override
    public void penDown() {
        this.penDown = true;
    }

    @Override
    public void penUp() {
        this.penDown = false;
    }

    @Override
    public void setGrid(IGrid grid) {
        this.grid = grid;
    }

    @Override
    public void prettyPrint() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setPrinted() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addStatement(IStatement statement) {
        statementList.add(statement);
    }

    @Override
    public Collection<IPosition> getPositions() {
        return this.positions;
    }   

    @Override
    public void addVarDecl(VarDecl vd) {
        globalVariableDeclarations.put(vd.getIdentifier(), vd);
    }
}
