package expression;

import Other.VarDecl;
import program.Robot;

/**
 * A robol identifier.
 * 
 * @author haavakno
 */
public class Identifier extends Expression {

    private String identifier;
    
    /**
     * Creates a robol identifier.
     * 
     * @param identifier unique name of the identifier.
     */
    public Identifier(String identifier) {
        this.identifier = identifier;
    }
    
    /**
     * Returns the value associated with this identifier.
     * 
     * @return value of expression associated with this identifier.
     * @throws RuntimeException
     */
    @Override
    public int getValue() {
        if (Robot.globalVariableDeclarations.get(this) == null) {
            throw new RuntimeException("Identifier has no declaration: " + this);
        }
        
        return Robot.globalVariableDeclarations.get(this).getValue();
    }
    
    @Override
    public String toString() {
        return identifier;
    }  
}
