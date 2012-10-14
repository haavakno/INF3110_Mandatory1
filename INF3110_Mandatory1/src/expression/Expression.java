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

    @Override
    public void interpret() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void setPrinted() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void prettyPrint() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
