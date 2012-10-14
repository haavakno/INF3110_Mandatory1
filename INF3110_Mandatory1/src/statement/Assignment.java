/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statement;

import expression.Identifier;
import interfaces.IExpression;
import program.Robot;


public class Assignment extends Statement {
    
    private Identifier identifier;
    private IExpression exp;
    
    public Assignment(Identifier identifier, IExpression exp) {
        this.identifier = identifier;
        this.exp = exp;
    }
    
    @Override
    public void interpret() {
        super.interpret();
        Robot.globalVariableDeclarations.get(identifier).setExpression(exp);
    }

    @Override
    public String toString() {
        return identifier + " = " + exp + ";";
    }
    
}
