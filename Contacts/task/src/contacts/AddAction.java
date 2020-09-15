package contacts;

/**
 * This is the Command concrete Class
 */
//TODO Add other concrete classes as well
public class AddAction implements ICommandAction {
    ActionReceiver mActionReceiver;
    public AddAction(ActionReceiver receiver)
    {
        this.mActionReceiver = receiver;

    }
    @Override
    public AbstractRecord execute() {

        return mActionReceiver.add();
    }
}
