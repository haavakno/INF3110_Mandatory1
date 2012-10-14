/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statement;

import interfaces.IExpression;


public class Backward extends Move {

    public Backward(IExpression exp) {
        super(exp);
    }
    
    @Override
    public void interpret() {
        super.interpret();
        super.getRobot().moveBackward(new expression.Number(super.getValue()));
    }
    
    @Override
    public String toString() {
        return "backward(" + super.exp + ")";
    }
}
