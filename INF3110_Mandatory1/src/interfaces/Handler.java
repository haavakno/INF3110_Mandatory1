package interfaces;

/**
 * Implemented by all Robol commands.
 * 
 * @author haavakno
 */
public interface Handler extends IPrettyPrint {
    /**
     * Interprets a Robol command
     */
    public void interpret();
}
