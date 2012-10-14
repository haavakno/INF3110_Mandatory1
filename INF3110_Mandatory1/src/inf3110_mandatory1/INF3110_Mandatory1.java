/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inf3110_mandatory1;

import Other.Direction;
import Other.Size;
import interfaces.IGrid;
import interfaces.IRobot;
import program.Grid;
import program.Program;
import program.Robot;
import expression.Number;

/**
 *
 * @author haavakno
 */
public class INF3110_Mandatory1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Number xBounds = new Number(12);
        Number yBounds = new Number(12);

        Size   gridSize = new Size(xBounds, yBounds);
        
        IRobot r = new Robot(new Number(3), new Number(3), Direction.getDirection("-x"));
        IGrid  g = new Grid(gridSize);
        Program p = new Program(r, g);
        p.interpret();
    }
}
