/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import Other.Direction;
import Other.Size;
import interfaces.IGrid;
import interfaces.IPosition;
import interfaces.IRobot;
import java.util.Arrays;

/**
 * A grid with a given width and height.
 * 
 * @author haavakno
 */
public class Grid implements IGrid {
    private final Size size;
    private IRobot robot;
    private boolean printed = false;
    
    /**
     * Create a grid with a given size.
     * 
     * @param size of this grid.
     */
    public Grid(Size size) {
        this.size = new Size(size);
        this.robot = null;
    }

    /**
     * Set this grids robot.
     * 
     * @param robot to be set.
     */
    @Override
    public void setRobot(IRobot robot) {
        this.robot = robot;
    }

    /**
     * @see interfaces.Handler.
     */
    @Override
    public void interpret() {
        prettyPrint();
    }

    /**
     * @see interfaces.IPrettyPrint
     */
    @Override
    public void prettyPrint() {
        if (!printed) {
            setPrinted();
            System.out.println(this);
        }
    }

    /**
     * @see interfaces.IPrettyPrint
     */
    @Override
    public void setPrinted() {
        this.printed = true;
    }
    
    /**
     * Creates a string of 'n' # with a newline at the end, where n is the 
     * length of the grid.
     * 
     * @return a string.
     */
    private String getHorizontalLine() {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x <= size.getXBounds().getValue() + 1; ++x) {
            sb.append("# ");
        }
        return sb.substring(0, sb.length() - 1).concat("\n");
    }
    
    @Override
    public String toString() {
        
        // Holds the grid to be printed
        StringBuilder sb = new StringBuilder();
       
        int xMax = size.getXBounds().getValue();
        int yMax = size.getYBounds().getValue();
        IPosition position = null;
        
        // Holds the positions where the robot had it's pen down
        char[] grid = new char[yMax * xMax];
        Arrays.fill(grid, '.');

        // Insert positions where robot had it's pen dow
        for (IPosition p: this.robot.getPositions()) {
            /* 
             * Transform the 2D index position to a 1D index. 
             * The grids y coordinates are the opposite of that in an 
             * cartesian coordinate system, thus we need to flip the robots
             * y coordinate.
             */
            int index = p.getXPosition().getValue() + (yMax - p.getYPosition().getValue() - 1) * xMax;
            grid[index] = Direction.getCharValue(p.getDirection());
        }
        
        sb.append(getHorizontalLine());
         
        for (int i = 0; i < grid.length; ++i) {
            
            // Print '#' at the start and end of each line.
            if (i%xMax == 0) {
                if (i != 0) {
                    sb.append("#\n# ");
                } else
                    sb.append("# ");
            }
            
            sb.append(grid[i]);
            sb.append(" ");                    
        }

        // Print the last '#' and add a ### line
        sb.append("#\n");
        sb.append(getHorizontalLine());
      
        return sb.toString();
    }

    /**
     * Check if a given position is inside the grid.
     * 
     * @param position to be checked.
     * @return true if inside grid.
     *         false if outside grid.
     */
    @Override
    public boolean legalMove(IPosition position) {
        
        return 0 <= position.getXPosition().getValue() && position.getXPosition().getValue() < size.getXBounds().getValue() &&
               0 <= position.getYPosition().getValue() && position.getYPosition().getValue() < size.getYBounds().getValue();
    }
    
    
    
}
