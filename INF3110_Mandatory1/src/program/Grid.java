/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import Other.Direction;
import Other.Size;
import com.sun.xml.internal.ws.util.StringUtils;
import interfaces.IRobot;
import interfaces.IGrid;
import interfaces.IPrettyPrint;
import expression.Number;
import interfaces.IPosition;
import java.util.Arrays;

/**
 *
 * @author haavakno
 */
public class Grid implements IGrid {
    private final Size size;
    private IRobot robot;
    private boolean printed = false;
    
    public Grid(Size size) {
        this.size = new Size(size);
        this.robot = null;
    }

    @Override
    public void setRobot(IRobot robot) {
        this.robot = robot;
    }

    @Override
    public void interpret() {
        prettyPrint();
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
    
    private String getHorizontalLine() {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x <= size.getXBounds().getValue() + 1; ++x) {
            sb.append("# ");
        }
        return sb.substring(0, sb.length() - 1).concat("\n");
    }
    
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append(getHorizontalLine());
        int xMax = size.getXBounds().getValue();
        int yMax = size.getYBounds().getValue();
        IPosition position = null;
        
        char[] grid = new char[yMax * xMax];
        Arrays.fill(grid, '.');

        for (IPosition p: this.robot.getPositions()) {
            int index = (p.getXPosition().getValue() - 1) + (p.getYPosition().getValue() - 1) * xMax;
            System.out.println("hei hei");
            grid[index] = Direction.getCharValue(p.getDirection());
        }
        
        for (int i = 0; i < grid.length; ++i) {
            
            if (i%xMax == 0) {
                if (i != 0) {
                    sb.append("#\n# ");
                } else
                    sb.append("# ");
            }
            
           // if (i != 0 && i%xMax == 0) {
  //              sb.append("#\n");
//            }
            
            sb.append(grid[i]);
            sb.append(" ");                    
        }
      
          sb.append("#\n");
        sb.append(getHorizontalLine());

      
        return sb.toString();
    }
    
    
    
}
