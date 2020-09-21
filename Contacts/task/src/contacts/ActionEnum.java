package contacts;

public class ActionEnum implements ICommandAction {
    public enum Action {
        ADD {
            @Override
            AbstractRecord execute() {
                return mActionReceiver.add();
            }
        },
        EDIT {
            @Override
            AbstractRecord execute() {
                return mActionReceiver.edit();
            }

        },
        REMOVE {
            @Override
            AbstractRecord execute() {
                return mActionReceiver.remove();
            }

        },
        INFO {
            @Override
            AbstractRecord execute() {
                return mActionReceiver.info();
            }

        },
        COUNT {
            @Override
            AbstractRecord execute() {
                return mActionReceiver.count();
            }

        },
        EXIT {
            @Override
            AbstractRecord execute() {

                return mActionReceiver.exit();
            }
        };

        abstract AbstractRecord execute();


        @Override
        public String toString() {
            return name().toLowerCase();
        }
    }

    static ActionReceiver mActionReceiver;
    Action mAction;


    public ActionEnum(Action action, ActionReceiver actionReceiver) {
        this.mAction = action;

        mActionReceiver = actionReceiver;


    }

    @Override
    public AbstractRecord execute() {
        return mAction.execute();
    }


    @Override
    public boolean status() {

        return mActionReceiver.isStatus();
    }
}
