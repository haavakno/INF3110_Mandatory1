/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expression;


public class Number extends Expression {
    
    private final int value;
    
    public Number(int value) {
        this.value = value;
    }
    
    public Number(Number number) {
        this.value = number.getValue();
    }

    @Override
    public int getValue() {
        return this.value;
    }
}
