/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Other.Direction;
import Other.VarDecl;
import java.util.LinkedList;
import java.util.List;
import expression.Number;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author haavakno
 */
public interface IRobot extends IRobotActions {
    public void addStatement(IStatement statement);
    public void addVarDecl(VarDecl vd);
    public void setGrid(IGrid grid);
    public Collection<IPosition> getPositions();
}
