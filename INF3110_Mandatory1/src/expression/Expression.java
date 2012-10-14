/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expression;

import interfaces.IExpression;

/**
 *
 * @author haavakno
 */
abstract class Expression implements IExpression {

    private boolean printed = false;
    private boolean evaluated = false;
    
    @Override
    public void interpret() {
   //     prettyPrint();
    }
    
    @Override
    public void setPrinted() {
        this.printed = true;
    }
    
    @Override
    public void prettyPrint() {
        if (!printed) {
            setPrinted();
            System.out.println(this);
        }
    }
    
    public void setEvaluated(boolean value) {
        this.evaluated = value;
    }
    
    protected boolean isEvaluated() {
        return this.evaluated;
    }
    
}
