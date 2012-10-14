/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statement;


public class Stop extends Statement {
    
    @Override
    public void interpret() {
        super.interpret();
        super.getRobot().stop();
    }
    
    @Override
    public String toString() {
        return "stop(" + super.getRobot() + ")";
    }
}
