/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statement;

import expression.Number;
import interfaces.IExpression;

public class Right extends Move {

    public Right(IExpression exp) {
        super(exp);
    }
    
    @Override
    public void interpret() {
        super.interpret();
        super.getRobot().moveRight(new Number(super.getValue()));
    }
    
    @Override
    public String toString() {
        return "right(" + super.exp + ")";
    }
    
}
