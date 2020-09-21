package contacts;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the Invoker Class
 */
public class ActionExecutor {

    private final List<ICommandAction> mICommandActionArrayList = new ArrayList<>();


    public AbstractRecord executeOperation(ICommandAction iCommandAction) {
        mICommandActionArrayList.add(iCommandAction);

        return iCommandAction.execute();
    }
}
