/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import expression.Number;

/**
 *
 * @author haavakno
 */
public class Size {
    private final Number xBounds;
    private final Number yBounds;
    
    public Size(Number xBounds, Number yBounds) {
        this.xBounds = new Number(xBounds);
        this.yBounds = new Number(yBounds);
    }
    
    public Size(Size size) {
        this.xBounds = new Number(size.getXBounds());
        this.yBounds = new Number(size.getYBounds());
    }
    
    public Number getXBounds() {
        return new Number(this.xBounds);
    }
    
    public Number getYBounds() {
        return new Number(this.yBounds);
    }
}
