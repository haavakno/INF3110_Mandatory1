/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statement;

import interfaces.Handler;
import interfaces.IStatement;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author haavakno
 */
public class StatementList implements Handler, Iterable<IStatement> {
    private final Collection<IStatement> statementList = new LinkedList<IStatement>();
    private boolean printed = false;
    
    public void addStatement(IStatement statement) {
        this.statementList.add(statement);
    }
    
    @Override
    public void interpret() {
        prettyPrint();
        for (IStatement statement : statementList) {
            statement.interpret();
        }
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
        StringBuilder sb = new StringBuilder();
        for (IStatement statement : statementList) {
            statement.setPrinted();
            sb.append(statement);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator iterator() {
        return statementList.iterator();
    }
}
