/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statement;

import Other.Direction;
import Other.Position;
import interfaces.IExpression;
import interfaces.IPosition;
import interfaces.IRobot;
import expression.Number;


public class Start extends Statement {

    IExpression exp1, exp2;
    Direction direction;
    
    public Start(IExpression exp1, IExpression exp2, Direction direction) {
        super();
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.direction = direction;
    }
    
    @Override
    public void interpret() {
        super.interpret();
        super.robot.setStartPosition(new Number(exp1.getValue()), new Number(exp2.getValue()), direction);
    }
    
    @Override
    public String toString() {
        return "start(" + exp1.getValue() + "," + exp2.getValue() + "," + direction + ")";
    }
}
