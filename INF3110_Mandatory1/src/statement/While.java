/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statement;

import expression.BooleanExpression;
import interfaces.IStatement;


public class While extends Statement {

    private BooleanExpression boolExp;
    private StatementList statementList;
    
    public While(BooleanExpression boolExp, StatementList statementList) {
        this.boolExp = boolExp;
        this.statementList = statementList;
    }
    
    @Override 
    public void interpret() {
        super.interpret();
        
        while (boolExp.getValue() == 1) {
            for (IStatement statement : statementList) {
                statement.interpret();
            }
        }
    }
    
    @Override
    public String toString() {
        return "while(" + boolExp + ") {\n" + statementList + "\n}";
    }
    
}
