/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statement;

import interfaces.IStatement;
import interfaces.Handler;
import interfaces.IPrettyPrint;
import interfaces.IRobot;

/**
 *
 * @author haavakno
 */
public class Statement implements IStatement {

    private IRobot robot;
    private State  state;
    private boolean printed = false;

    @Override
    public void prettyPrint() {
        if (!printed) {
            setPrinted();
            System.out.println(this);
        }
    }

    @Override
    public void setPrinted() {
        this.printed = true;
    }
    
    enum State {
        uninitialized,
        initialized;
    }
    
    public Statement() {
        this.state = State.uninitialized;
    }
    
    public Statement(IRobot robot) {
        this.robot = robot;
        this.state = State.initialized;
    }    
    
    @Override
    public void interpret() {
        prettyPrint();
        
    }
    
    @Override
    public void setRobot(IRobot robot) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
