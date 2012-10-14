/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Other.VarDecl;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author haavakno
 */
public interface IProgram extends Handler {
    public void addStatement(IStatement statement);
    public void addVarDecl(VarDecl vd);
}
