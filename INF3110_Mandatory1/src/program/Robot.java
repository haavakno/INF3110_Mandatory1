/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import Other.Direction;
import Other.Position;
import interfaces.Handler;
import interfaces.IGrid;
import interfaces.IPosition;
import interfaces.IPrettyPrint;
import interfaces.IRobot;
import interfaces.IStatement;
import expression.Number;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author haavakno
 */
public class Robot implements IRobot {

    private IGrid grid;
    private IPosition position;

    private Collection<IPosition> positions = new LinkedList<IPosition>();
   
    public Robot(IPosition position) {
        this.position = position;
        positions.add(position);
    }
    
    public Robot(Number xPosition, Number yPosition, Direction direction) {
        this.position = new Position(xPosition, yPosition, direction);
        positions.add(position);
    }
    
    @Override
    public void interpret() {
        for (Handler statement : statementList) {
            statement.interpret();
        }
    }

    @Override
    public void moveBackward(Number number) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void moveForward(Number number) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void moveRight(Number number) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void moveLeft(Number number) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void penDown() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void penUp() {
        throw new UnsupportedOperationException("Not supported yet.");
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
}
