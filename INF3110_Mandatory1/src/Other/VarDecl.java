package Other;

import expression.Identifier;
import interfaces.Handler;
import interfaces.IExpression;
import interfaces.IPrettyPrint;

/**
 * A robol variable declaration.
 * 
 * Contains an identifier and an expression.
 * 
 * @author haavakno
 */
public class VarDecl implements Handler {

    private final Identifier identifier;
    private IExpression exp;
    /**
     * @see interfaces.IPrettyPrint 
     */
    private boolean printed = false;
    
    /**
     * Creates a VarDecl with Robol language.
     * 
     * @param identifier identifier of this declaration.
     * @param exp which the identifier points at.
     */
    public VarDecl(Identifier identifier, IExpression exp) {
        this.identifier = identifier;
        this.exp = exp;
    }
    
    /**
     * Prints out this object with prettyPrint.
     */
    @Override
    public void interpret() {
        prettyPrint();
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
     * @see interfaces.IPrettyPrint
     */
    @Override
    public void setPrinted() {
        this.printed = true;
    }
    
    @Override
    public String toString() {
        return "var " + identifier + " = " + exp + ";";
    }
    
    /**
     * Returns the identifier of this declaration.
     * 
     * @return identifier of this object.
     */
    public Identifier getIdentifier() {
        return this.identifier;
    }
    
    /**
     * Returns the value of this objects expression.
     * 
     * @return value of this objects expression.
     */
    public int getValue() {
        return this.exp.getValue();
    }

    /**
     * Updates this declaration to point at a new expression.
     * 
     * @param exp new expression of this declaration.
     */
    public void setExpression(IExpression exp) {
        
        // With a new expression, the identifier is no longer evaluated
        identifier.setEvaluated(false);
        
        /**
         * The expression needs to be interpreted if the expression contains
         * a reference to this objects identifier.
         */        
        exp.interpret();
        this.exp = exp;
    }
    
}
