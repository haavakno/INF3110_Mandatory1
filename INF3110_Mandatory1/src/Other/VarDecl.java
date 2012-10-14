/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import expression.Identifier;
import interfaces.Handler;
import interfaces.IExpression;

/**
 *
 * @author haavakno
 */
public class VarDecl implements Handler {

    private final Identifier identifier;
    private IExpression exp;
    private boolean printed = false;
    
    public VarDecl(Identifier identifier, IExpression exp) {
        this.identifier = identifier;
        this.exp = exp;
    }
    
    @Override
    public void interpret() {
        prettyPrint();
    }

    @Override
    public void prettyPrint() {
        if (!printed) {
            setPrinted();
            System.out.println(this);
        }
    }

    @Override
    public void setPrinted() {
        this.printed = true;
    }
    
    @Override
    public String toString() {
        return "var " + identifier + " = " + exp + ";";
    }
    
    public Identifier getIdentifier() {
        return this.identifier;
    }
    
    public int getValue() {
        return this.exp.getValue();
    }
    
}
