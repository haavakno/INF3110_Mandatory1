package Other;

import expression.Number;

/**
 * Holds the x and y bounds of a rectangle.
 * 
 * @author haavakno
 */
public class Size {
    private final Number xBounds;
    private final Number yBounds;
    
    /**
     * Creates a Size object with Robol language.
     * 
     * @param xBounds width of size.
     * @param yBounds height of size.
     */
    public Size(Number xBounds, Number yBounds) {
        this.xBounds = new Number(xBounds);
        this.yBounds = new Number(yBounds);
    }
    
    /**
     * Creates a Size object from another size object.
     * 
     * @param size 
     */
    public Size(Size size) {
        this.xBounds = new Number(size.getXBounds());
        this.yBounds = new Number(size.getYBounds());
    }
    
    /**
     * Returns the width of this object.
     * 
     * @return width of this object.
     */
    public Number getXBounds() {
        return new Number(this.xBounds);
    }
    
    /**
     * Returns the height of this object.
     * 
     * @return height of this object.
     */
    public Number getYBounds() {
        return new Number(this.yBounds);
    }
}
