/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Other.Direction;
import expression.Number;

/**
 *
 * @author haavakno
 */
interface IRobotActions extends Handler {
    public void moveBackward(Number number);
    public void moveForward(Number number);
    public void moveRight(Number number);
    public void moveLeft(Number number);
    public void penDown();
    public void penUp();
}
