/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statement;


/**
 *
 * @author haavakno
 */
public class PenUp extends Statement {

    /**
     *
     */
    public PenUp() {
        super();
    }
    
    /**
     *
     */
    @Override
    public void interpret() {
        super.interpret();
        super.getRobot().penUp();
    }
    
    @Override
    public String toString() {
        return "penUp";
    }
    
}
