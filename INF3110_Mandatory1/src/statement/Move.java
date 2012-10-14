/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statement;

import interfaces.IExpression;
import interfaces.IRobot;

abstract class Move extends Statement {

    protected IExpression exp;
 
    public Move(IExpression exp) {
        super();
        this.exp = exp;
    }

    public Move(IRobot robot, IExpression exp) {
        super(robot);
        this.exp = exp;
    }
    
    protected int getValue() {
        return exp.getValue();
    }
}
