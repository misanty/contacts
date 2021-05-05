package menu;
import java.util.stream.Stream;

enum MenuOption implements Runnable {
    ADD {
        @Override
        public void execute() {
            executive.returnState("Enter the type (person, organization): ");
            executive.init().add();
        }
    },
    LIST {
        @Override
        public void execute() {

            while ( executive.init().list())
            {
                execute();
            }
        }
    },
    SEARCH {


        @Override
        public void execute() {
            while (executive.init().search()) {
                execute();

            }

        }
    },

    COUNT {
        @Override
        public void execute() {
            executive.init().count();
        }
    },
    EXIT {
        @Override
        public void execute() {
            Menu.exit();

        }

    };

    Executive executive;

    MenuOption() {
        executive = Menu.getInstance();
    }

    public abstract void execute();

    @Override
    public void run() {
        execute();
    }

    public static Stream<MenuOption> stream() {
        return Stream.of(MenuOption.values());
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
