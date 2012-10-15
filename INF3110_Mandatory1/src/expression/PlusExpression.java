package expression;

import Other.Operator;
import interfaces.IExpression;


/**
 * Robol language PlusExpression.
 * 
 * @author haavakno
 */
public class PlusExpression extends Expression {

    private IExpression exp1, exp2;
    private Operator op;
    private int value;
    
    /**
     * Create a PlusExpression from the Robol language.
     * 
     * @param op an operand.
     * @param exp1 an expression.
     * @param exp2 an expression.
     */
    public PlusExpression(Operator op, IExpression exp1, IExpression exp2) {
        this.op = op;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    /**
     * Create a PlusExpression.
     * 
     * @param string a string representation of an operand.
     * @param exp1 an expression.
     * @param exp2 an expression.
     */
    public PlusExpression(String string, IExpression exp1, IExpression exp2) {
        this(Operator.getOperator(string), exp1, exp2);
    }
    
    /**
     * Evaluates the value of this Expression.
     * 
     * Stores the value of the result after using the operator on both expressions.
     * Marks this expression as evaluated.
     * 
     * @see interfaces.Handler
     */
    @Override 
    public void interpret() {      

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
        
        super.setEvaluated(true);
    }
    
    /**
     * @see interfaces.IExpression
     */
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
