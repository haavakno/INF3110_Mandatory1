package interfaces;

import Other.VarDecl;
import java.util.Collection;

/**
 * Implemented by those who wants to initialize a robot and get
 * its position.
 * 
 * @author haavakno
 */
public interface IRobot extends IRobotActions {
    /**
     * Adds a Robol statement to a robot.
     * 
     * @param statement a robol statement.
     */
    public void addStatement(IStatement statement);
    
    /**
     * Adds a Robol variable declaration to a robot.
     * 
     * @param vd a robol variable declaration.
     */
    public void addVarDecl(VarDecl vd);
    
    /**
     * Adds a grid for the robot to move in.
     * 
     * @param grid a grid with boundaries.
     */
    public void setGrid(IGrid grid);
    
    /**
     * Returns the robots current position.
     * 
     * @return current position of robot.
     */
    public Collection<IPosition> getPositions();
}
