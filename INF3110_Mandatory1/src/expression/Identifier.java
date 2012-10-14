/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expression;

import Other.VarDecl;
import program.Robot;


public class Identifier extends Expression {

    private String identifier;
    private VarDecl vd = null;
    
    public Identifier(String identifier) {
        this.identifier = identifier;
    }
    
    @Override
    public int getValue() {
        if (Robot.globalVariableDeclarations.get(this) == null) {
            throw new RuntimeException("Identifier has no declaration: " + this);
        }
        
        return Robot.globalVariableDeclarations.get(this).getValue();
   /*     if (isEvaluated()) {
            if (vd == null) {
                throw new RuntimeException("Variable not declared: " + this);
            }
            return vd.getValue();
        } else {
            setEvaluated(true);
            interpret();
            return getValue();
        }*/
    }
    
    @Override
    public void interpret() {
        super.interpret();
        System.out.println("Evaluating: " + this);
      //  vd = Robot.globalVariableDeclarations.get(this);
    }
    
    @Override
    public String toString() {
        return identifier;
    }  
}
