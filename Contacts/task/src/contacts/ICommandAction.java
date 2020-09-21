package contacts;

/**
 * This is the Command Interface
 */
public interface ICommandAction {
    AbstractRecord execute();
    boolean status();
}
