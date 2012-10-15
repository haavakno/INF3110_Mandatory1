package expression;

import interfaces.IExpression;

/**
 * A Robol expression.
 * 
 * @author haavakno
 */
abstract class Expression implements IExpression {

    private boolean printed = false;
    private boolean evaluated = false;
    
    /**
     * 
     */
    @Override
    public void interpret() {
        
    }
    /**
     * @see interfaces.IPrettyPrint
     */
    @Override
    public void setPrinted() {
        this.printed = true;
    }
    
    /**
     * @see interfaces.IPrettyPrint
     */
    @Override
    public void prettyPrint() {
        if (!printed) {
            setPrinted();
            System.out.println(this);
        }
    }
    
    /**
     * Marks this expression as evaluated/not evaluated.
     * 
     * @param value boolean value.
     */
    public void setEvaluated(boolean value) {
        this.evaluated = value;
    }
    
    /**
     * Checks if this expression has been evaluated.
     * 
     * @return boolean value.
     */
    protected boolean isEvaluated() {
        return this.evaluated;
    }
    
}
