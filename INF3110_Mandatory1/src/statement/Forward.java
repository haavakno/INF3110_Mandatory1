/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statement;

import interfaces.IExpression;
import expression.Number;

/**
 *
 * @author haavakno
 */
public class Forward extends Move {

    /**
     *
     * @param exp
     */
    public Forward(IExpression exp) {
        super(exp);
    }
    
    /**
     *
     */
    @Override
    public void interpret() {
        super.interpret();
        super.getRobot().moveForward(new Number(super.getValue()));
    }
    
    @Override
    public String toString() {
        return "forward(" + super.exp + ")";
    }
}
