/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expression;

import Other.Operator;
import interfaces.IExpression;


public class BooleanExpression extends Expression {

    private IExpression exp1, exp2;
    private Operator rel;
    private int value;
    
    public BooleanExpression(Operator rel, IExpression exp1, IExpression exp2) {
        this.rel = rel;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }
    
    @Override
    public void interpret() {
        super.interpret();
       
        int value1 = exp1.getValue();
        int value2 = exp2.getValue();
        
        switch (rel) {
            case LESS:
                this.value = value1 < value2 ? 1 : 0;
                break;
            case GREATER:
                this.value = value1 > value2 ? 1 : 0;
                break;
            case EQUAL:
                this.value = value1 == value2 ? 1 : 0;
                break;
            default:
                throw new RuntimeException("Unknown rel operator: " + rel);
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
}
