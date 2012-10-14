/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inf3110_mandatory1;

import Other.Direction;
import Other.Size;
import Other.VarDecl;
import expression.Identifier;
import interfaces.IGrid;
import interfaces.IRobot;
import program.Grid;
import program.Program;
import program.Robot;
import expression.Number;
import statement.Backward;
import statement.Forward;
import statement.Left;
import statement.PenDown;
import statement.PenUp;
import statement.Right;
import statement.Start;

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
        
        IRobot r = new Robot();
        IGrid  g = new Grid(gridSize);
        Program p = new Program(r, g);
        Identifier ii = new Identifier("ii");
        Identifier jj = new Identifier("jj");
        Identifier kk = new Identifier("kk");
        p.addStatement(new Start(new Number(3), new Number(3), Direction.getDirection("-x")));
        p.addStatement(new PenDown());
        p.addStatement(new Forward(new Number(1)));
        p.addStatement(new PenUp());
        p.addStatement(new Right(new Number(2)));
        p.addStatement(new PenDown());
        p.addStatement(new Right(new Number(5)));
        p.addStatement(new Backward(new Number(3)));
        p.addStatement(new Left(new Number(2)));
        p.addStatement(new Left(new Number(2)));
        p.addStatement(new Left(new Number(10)));
        p.addVarDecl(new VarDecl(ii, new Number(5)));
        p.addVarDecl(new VarDecl(jj, ii));
        p.addVarDecl(new VarDecl(kk, jj));
        p.addStatement(new Right(ii));
        p.addStatement(new Right(jj));
        p.addStatement(new Backward(kk));
        p.interpret();
    }
}
