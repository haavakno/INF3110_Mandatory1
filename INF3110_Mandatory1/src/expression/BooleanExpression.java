package expression;

import Other.Operator;
import interfaces.IExpression;

/**
 * A Robol boolean expression.
 * 
 * Contanins to expressions and an operator to be used on those expressions.
 * @author haavakno
 */
public class BooleanExpression extends Expression {

    private IExpression exp1, exp2;
    private Operator rel;
    private int value;
    
    /**
     * Creates a boolean expression with the Robol language.
     * 
     * @param rel a relation operator.
     * @param exp1 an expression.
     * @param exp2 an expression.
     */
    public BooleanExpression(Operator rel, IExpression exp1, IExpression exp2) {
        this.rel = rel;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    /**
     * Creates a boolean expression like above.
     * @param string a relation operator.
     * @param exp1 an expression.
     * @param exp2 an expression.
     */
    public BooleanExpression(String string, IExpression exp1, IExpression exp2) {
        this(Operator.getOperator(string), exp1, exp2);
    }
    
    /**
     * Evaluates the boolean expression.
     * 
     * If the boolean expression is true, the value of this expression
     * is set to 1. If its false, the value is set to 0.
     * 
     * @throws RuntimeException
     * @see interfaces.Handler
     */
    @Override
    public void interpret() {
       
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
    
    /**
     * Returns this expressions value.
     * 
     * Interprets the value of this expression, marks it as evaluated and returns
     * the value of the expression.
     * @return value of this object.
     */
    @Override
    public int getValue() {
        super.setEvaluated(true);
        this.interpret();
        return this.value;
    }  
    
    @Override
    public String toString() {
        return exp1 + " " + rel +  " " + exp2;
    }
}
