/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statement;


public class PenDown extends Statement {

    public PenDown() {
        super();
    }
    
    @Override
    public void interpret() {
        super.interpret();
        super.getRobot().penDown();
    }
    
    @Override
    public String toString() {
        return "penDown";
    }
            
    
}
