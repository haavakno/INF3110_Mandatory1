/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import Other.VarDecl;
import interfaces.Handler;
import interfaces.IGrid;
import interfaces.IPrettyPrint;
import interfaces.IRobot;
import interfaces.IStatement;
import statement.Statement;

/**
 *
 * @author haavakno
 */
public class Program implements Handler {
    
    private final IRobot robot;
    private final IGrid  grid;
    
    /**
     *
     * @param robot
     * @param grid
     */
    public Program(IRobot robot, IGrid grid) {
        this.robot = robot;
        this.grid  = grid;
        this.robot.setGrid(this.grid);
        this.grid.setRobot(this.robot);
        Statement.robot = this.robot;
    }

    /**
     * @see interfaces.Handler
     */
    @Override
    public void interpret() {
        robot.interpret();
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
     * Adds a statement to the robot.
     * 
     * @param statement to be added.
     */
    public void addStatement(IStatement statement) {
        robot.addStatement(statement);
    }

    /**
     * Adds a Variable declaration to the robot.
     * 
     * @param vd to be added.
     */
    public void addVarDecl(VarDecl vd) {
        this.robot.addVarDecl(vd);
    }
}
