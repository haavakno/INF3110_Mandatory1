/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statement;

import interfaces.IExpression;


/**
 *
 * @author haavakno
 */
public class Left extends Move {

    /**
     *
     * @param exp
     */
    public Left(IExpression exp) {
        super(exp);
    }
    
    /**
     *
     */
    @Override
    public void interpret() {
        super.interpret();
        super.getRobot().moveLeft(new expression.Number(super.getValue()));
    }
    
    @Override
    public String toString() {
        return "left(" + super.exp + ")";
    }
    
}
