/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author haavakno
 */
public enum Operator {
    
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    LESS("<"),
    GREATER(">"),
    EQUAL("=");
    
    
    private String value;
    private Operator(String value) {
        this.value = value;
    }
    
    public static Operator getOperator(String value) {
        for (Operator op : Operator.values()) {
            if (op.value.equals(value)) {
                return op;
            }
        }
        
        throw new RuntimeException("Unknown operator: " + value);
    }
    
    @Override
    public String toString() {
        return this.value;
    }
    
}
