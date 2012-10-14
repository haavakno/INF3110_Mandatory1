/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statement;

import expression.BooleanExpression;


public class IfThenElse extends Statement {
    
    private BooleanExpression boolExp;
    private StatementList ifStatements;
    private StatementList elseStatements;
    
    public IfThenElse(BooleanExpression boolExp, StatementList ifStatements) {
        this.boolExp = boolExp;
        this.ifStatements = ifStatements;
        this.elseStatements = null;
    }
    
    public IfThenElse(BooleanExpression boolExp, StatementList ifStatements, StatementList elseStatements) {
        this(boolExp, ifStatements);
        this.elseStatements = elseStatements;
    }
    
    @Override
    public void interpret() {
        super.interpret();
        
        if (boolExp.getValue() == 1) {
            ifStatements.interpret();
        } else if (elseStatements != null) {
            elseStatements.interpret();
        }
    }
    
    @Override
    public String toString() {
        return "if(" + boolExp + ") {\n" + ifStatements.toString() + "}" + (elseStatements != null ? " else {\n" + elseStatements.toString() + "}" : "");
    }
}
