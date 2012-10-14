/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import Other.VarDecl;
import interfaces.Handler;
import interfaces.IGrid;
import interfaces.IPrettyPrint;
import interfaces.IProgram;
import interfaces.IRobot;
import interfaces.IStatement;
import statement.Statement;

/**
 *
 * @author haavakno
 */
public class Program implements IProgram {
    
    private final IRobot robot;
    private final IGrid  grid;
    
    public Program(IRobot robot, IGrid grid) {
        this.robot = robot;
        this.grid  = grid;
        this.robot.setGrid(this.grid);
        this.grid.setRobot(this.robot);
        Statement.robot = this.robot;
    }

    @Override
    public void interpret() {
        robot.interpret();
        grid.interpret();
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
        robot.addStatement(statement);
    }

    @Override
    public void addVarDecl(VarDecl vd) {
        this.robot.addVarDecl(vd);
    }
}
