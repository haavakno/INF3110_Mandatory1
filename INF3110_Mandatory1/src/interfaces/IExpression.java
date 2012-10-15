package interfaces;

/**
 *
 * @author haavakno
 */
public interface IExpression extends Handler {
    /**
     * Returns the value of this expression.
     * 
     * If the expression isn't evaluated, the expression is enterpreted and
     * the value is stored in the expressions value variable and it is marked
     * as evaluated. If the expression is evaluated, the evaluated value is returned.
     * 
     * @return value of this expression.
     */
    public int getValue();
}
