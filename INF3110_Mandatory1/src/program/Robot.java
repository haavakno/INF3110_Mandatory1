package program;

import Other.Direction;
import Other.Position;
import Other.VarDecl;
import expression.Identifier;
import expression.Number;
import interfaces.Handler;
import interfaces.IGrid;
import interfaces.IPosition;
import interfaces.IPositionActions;
import interfaces.IRobot;
import interfaces.IStatement;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import log.Log;
import statement.StatementList;

/**
 * 
 * @author haavakno
 */
public class Robot implements IRobot {

    /**
     * Stores variable declarations.
     */
    public static Map<Identifier, VarDecl> globalVariableDeclarations = new HashMap<Identifier, VarDecl>();
    private StatementList statementList = new StatementList();
    
    private IGrid grid;
    private IPositionActions position = null;
    private boolean penDown = false;

    /**
     * Stores positions robot moved over with penDown
     */
    private Collection<IPosition> positions = new LinkedList<IPosition>();
    
    /**
     * Interprets the variable declarations and statements of this robot.
     * 
     * @see interfaces.Handler
     */
    @Override
    public void interpret() {
        for (Handler varDecl : globalVariableDeclarations.values()) {
            varDecl.interpret();;
        }
        
        for (Handler statement : statementList) {
            statement.interpret();
        }
    }

    /**
     * @see interfaces.IRobotActions
     */
    @Override
    public void moveBackward(Number number) {
        this.position.turnAround();
        this.moveForward(number);
    }

    /**
     * @see interfaces.IRobotActions
     */
    @Override
    public void moveForward(Number number) {

        IPositionActions position;
        
        Log.log("Robot: Moving from (" + this.position + ") ");
        
        // Move one and one step at a time.
        for (int i = 1; i <= number.getValue(); ++i) {
            
            int x = 0;
            int y = 0;
            
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
    
    /**
     * Update this robots position.
     * 
     * If the pen is down, store current position.
     * 
     * @param position new position.
     */
    private void setPosition(IPositionActions position) {
        this.position = position;
        if (penDown) {
            this.positions.add(position);
        } 
    }
    
    /**
     * Set start position of robot.
     * 
     * If position is legal, set robots position and store it.
     * 
     * @param xBounds
     * @param yBounds
     * @param direction 
     * @throws RuntimeException
     */
    private void setStartPosition(Number xBounds, Number yBounds, Direction direction) {
        IPositionActions position = new Position(xBounds, yBounds, direction);
        if (grid.legalMove(position)) {
            this.position = position;
            positions.add(position);
        } else {
            throw new RuntimeException("Start position outside of grid: " + position);
        }
        Log.logln("Robot: Starting at (" + position + ")");

    }

    /**
     * @see interfaces.IRobotActions
     */
    @Override
    public void moveRight(Number number) {
        this.position.turnRight();
        this.moveForward(number);
    }

    /**
     * @see interfaces.IRobotActions
     */
    @Override
    public void moveLeft(Number number) {
        this.position.turnLeft();
        this.moveForward(number);
    }

    /**
     * @see interfaces.IRobotActions
     */
    @Override
    public void penDown() {
        this.penDown = true;
    }

    /**
     * @see interfaces.IRobotActions
     */
    @Override
    public void penUp() {
        this.penDown = false;
    }

    /**
     * @see interfaces.IRobot
     */
    @Override
    public void setGrid(IGrid grid) {
        this.grid = grid;
    }

    /**
     * @see interfaces.IPrettyPrint
     */
    @Override
    public void prettyPrint() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @see interfaces.IPrettyPrint
     */
    @Override
    public void setPrinted() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @see interfaces.IRobot
     */
    @Override
    public void addStatement(IStatement statement) {
        statementList.addStatement(statement);
    }

    /**
     * @see interfaces.IRobot
     */
    @Override
    public Collection<IPosition> getPositions() {
        return this.positions;
    }   

    /**
     * @see interfaces.IRobot
     */
    @Override
    public void addVarDecl(VarDecl vd) {
        globalVariableDeclarations.put(vd.getIdentifier(), vd);
    }

    /**
     * @see interfaces.IRobotActions
     */
    @Override
    public void start(Number x, Number y, Direction dir) {
        this.setStartPosition(x, y, dir);
    }

    /**
     * @see interfaces.IRobotActions
     */
    @Override
    public void stop() {
        this.grid.interpret();
    }
    
    @Override
    public String toString() {
        return this.position.toString();
    }
}
