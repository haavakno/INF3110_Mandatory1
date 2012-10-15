package interfaces;

import interfaces.IRobot;

/**
 * Empty interface implemented by statements.
 * 
 * Statements only need to show their interpret command, but there are
 * cases where we want to make sure we are working with statements and not
 * some other kind of object with the Handler interface.
 * @author haavakno
 */
public interface IStatement extends Handler {
}
