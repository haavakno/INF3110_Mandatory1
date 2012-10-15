/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statement;

import interfaces.IStatement;
import interfaces.Handler;
import interfaces.IPrettyPrint;
import interfaces.IRobot;
import interfaces.IRobotActions;

/**
 *
 * @author haavakno
 */
public class Statement implements IStatement {

    /**
     *
     */
    public static IRobot robot = null;
    private State  state;
    private boolean printed = false;

    /**
     *
     */
    @Override
    public void prettyPrint() {
        if (!printed) {
            setPrinted();
            System.out.println(this);
        }
    }

    /**
     *
     */
    @Override
    public void setPrinted() {
        this.printed = true;
    }
    
    enum State {
        uninitialized,
        initialized;
    }
    
    /**
     *
     */
    public Statement() {
        this.state = State.uninitialized;
    }
    
    /**
     *
     * @param robot
     */
    public Statement(IRobot robot) {
        this.robot = robot;
        this.state = State.initialized;
    }    
    
    /**
     *
     */
    @Override
    public void interpret() {
        prettyPrint();
        
    }
    
    /**
     *
     * @return
     */
    protected IRobotActions getRobot() {
        return this.robot;
    }
    
}
