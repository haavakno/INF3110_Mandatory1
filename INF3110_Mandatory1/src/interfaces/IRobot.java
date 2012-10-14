/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.LinkedList;
import java.util.List;
import expression.Number;
import java.util.Collection;
/**
 *
 * @author haavakno
 */
public interface IRobot extends IRobotActions {
    final List<IStatement> statementList = new LinkedList<IStatement>();
    public void addStatement(IStatement statement);
    public void setGrid(IGrid grid);
    public Collection<IPosition> getPositions();
}
