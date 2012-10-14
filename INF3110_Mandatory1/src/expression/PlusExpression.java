/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expression;

import Other.Operator;
import interfaces.IExpression;


public class PlusExpression extends Expression {

    private IExpression exp1, exp2;
    private Operator op;
    private int value;
    
    public PlusExpression(Operator op, IExpression exp1, IExpression exp2) {
        this.op = op;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }
    
    @Override 
    public void interpret() {      
        super.interpret();;

        int value1 = exp1.getValue();
        int value2 = exp2.getValue();

        switch (op) {
            case ADD:
                this.value = value1 + value2;
                break;
            case SUBTRACT:
                this.value = value1 - value2;
                break;
            case MULTIPLY:
                this.value = value1 * value2;
                break;
            default:
                throw new RuntimeException("Unknown operator: " + op);
        } 
    }
    
    @Override
    public int getValue() {
        
        if (isEvaluated()) {
            return this.value;
        } else {
            super.setEvaluated(true);
            this.interpret();
            return getValue();
        }
    }
    
    @Override
    public String toString() {
        return exp1 + " " + op.toString() + " " + exp2;
    }
    
}
