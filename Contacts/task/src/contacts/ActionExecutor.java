package contacts;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the Invoker Class
 */
public class ActionExecutor {
    //The list is added to store the commands executed, added.
    //You don't have have it as a list, but if you have make it to do multiple command operations consecutively, wanna reach the every command that's made, and/or rollback them.
    //Then it's good to have this field as a List object.
    //This is the invoker, it doesn't have to know what the receiver wants to do.
    //It's like a remote, a button can be programmed for multiple actions, so, a button doesn't know, a button is just a middleman, just passing through what it's wanted
    //TODO examine the list that's created, and reach the elements of the list and observe them :)
    private final List<ICommandAction> mICommandActionArrayList = new ArrayList<>();


    public AbstractRecord executeOperation(ICommandAction iCommandAction) {
        mICommandActionArrayList.add(iCommandAction);
        return iCommandAction.execute();
    }
}
