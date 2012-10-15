/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inf3110_mandatory1;

import Other.Direction;
import Other.Size;
import Other.VarDecl;
import expression.BooleanExpression;
import expression.Identifier;
import expression.Number;
import expression.PlusExpression;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import program.Grid;
import program.Program;
import program.Robot;
import statement.*;

/**
 *
 * @author haavakno
 */
public class INF3110_Mandatory1 {
              
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Number xBounds = new Number(64);
        Number yBounds = new Number(64);

        Size   gridSize = new Size(xBounds, yBounds);

        simpleExample(gridSize);
        exampleWithVariables(gridSize);
        exampleWithWhileLoop(gridSize);
        exampleWithIfThenElse(gridSize);
    }
    
    /**
     *
     * @param gridSize
     */
    public static void exampleWithIfThenElse(Size gridSize) {
        
        Robot r = new Robot();
        Grid g  = new Grid(gridSize);
        Program p = new Program(r, g);
        System.out.println("Example with if then else");

        Identifier i = new Identifier("i");
        Identifier j = new Identifier("j");
        p.addVarDecl(new VarDecl(i, new Number(5)));
        p.addVarDecl(new VarDecl(j, new Number(3)));
        p.addStatement(new Start(new Number(23), new Number(6), Direction.LEFT));
        p.addStatement(new PenDown());
        p.addStatement(new Forward(new PlusExpression("*", new Number(3), i)));
        p.addStatement(new Right(new Number(15)));
        p.addStatement(new Left(new Number(4)));
        p.addStatement(new Backward(new PlusExpression("+", new PlusExpression("+", new PlusExpression("*", new Number(2), i), new PlusExpression("*", new Number(3), j)), new Number(5))));
        StatementList stmtList = new StatementList();
        stmtList.addStatement(new Right(j));
        stmtList.addStatement(new Assignment(j, new PlusExpression("-", j, new Number(1))));
        p.addStatement(new While(new BooleanExpression(">", j, new Number(0)), stmtList));
        p.addStatement(new IfThenElse(new BooleanExpression(">", i, new Number(3)), new StatementList().addStatement(new Forward(new Number(14))), new StatementList().addStatement(new Backward(new Number(14)))));
        p.addStatement(new Stop());
        p.interpret();
        System.out.println("--------------------------------------");
    }
    /**
     *
     * @param gridSize
     */
    public static void exampleWithWhileLoop(Size gridSize) {
        
        Robot r = new Robot();
        Grid g  = new Grid(gridSize);
        Program p = new Program(r, g);
        System.out.println("Example with while loop");
        Identifier i = new Identifier("i");
        Identifier j = new Identifier("j");
        
        p.addVarDecl(new VarDecl(i, new Number(5)));;
        p.addVarDecl(new VarDecl(j, new Number(3)));
        
        p.addStatement(new Start(new Number(23), new Number(6), Direction.LEFT));
        p.addStatement(new PenDown());
        p.addStatement(new Forward(new PlusExpression("*", new Number(3), i)));
        p.addStatement(new Right(new Number(15)));
        p.addStatement(new Left(new Number(4)));
        p.addStatement(new Backward(new PlusExpression("+", new PlusExpression("+", new PlusExpression("*", new Number(2), i), new PlusExpression("*", new Number(3), j)), new Number(5))));
        StatementList stmtList = new StatementList();
        stmtList.addStatement(new Right(j));
        stmtList.addStatement(new Assignment(j, new PlusExpression("-", j, new Number(1))));
        p.addStatement(new While(new BooleanExpression(">", j, new Number(0)), stmtList));
        p.addStatement(new Stop());
        p.interpret();
        System.out.println("--------------------------------------");
    }
    
    /**
     *
     * @param gridSize
     */
    public static void simpleExample(Size gridSize) {
        
        Robot r = new Robot();
        Grid g  = new Grid(gridSize);
        Program p = new Program(r, g);
        System.out.println("Simple example");
        p.addStatement(new Start(new Number(23), new Number(30), Direction.LEFT));
        p.addStatement(new PenDown());
        p.addStatement(new Forward(new Number(15)));
        p.addStatement(new Left(new Number(15)));
        p.addStatement(new Right(new PlusExpression("+", new Number(2), new Number(3))));
        p.addStatement(new Backward(new PlusExpression("+", new Number(10), new Number(27))));
        p.addStatement(new Stop());
        p.interpret();
        System.out.println("--------------------------------------");
    }
    /**
     *
     * @param gridSize
     */
    public static void exampleWithVariables(Size gridSize) {
        
        Robot r = new Robot();
        Grid g  = new Grid(gridSize);
        Program p = new Program(r, g);
        System.out.println("Example with variables");
        Identifier i = new Identifier("i");
        Identifier j = new Identifier("j");
        p.addVarDecl(new VarDecl(i, new Number(5)));
        p.addVarDecl(new VarDecl(j, new Number(3)));
        p.addStatement(new Start(new Number(23), new Number(6), Direction.LEFT));
        p.addStatement(new PenDown());
        p.addStatement(new Forward(new PlusExpression("*", new Number(3), i)));
        p.addStatement(new Right(new Number(15)));
        p.addStatement(new Left(new Number(4)));
        p.addStatement(
                new Backward(
                new PlusExpression(
                    "+", 
                    new PlusExpression(
                        "+", 
                        new PlusExpression(
                            "*", 
                            new Number(2),
                            i), 
                        new PlusExpression(
                            "*", 
                            new Number(3), 
                            j)), 
                    new Number(5))));
        p.addStatement(new Stop());
        p.interpret();
        System.out.println("--------------------------------------");
    }
}
