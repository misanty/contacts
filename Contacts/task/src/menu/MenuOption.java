package menu;
import java.util.stream.Stream;
enum MenuOption implements Runnable {
    ADD {
        @Override
        public void execute() {
            Menu.mExecuteCrud.add();
        }
    },
    LIST {
        @Override
        public void execute() {
            executive.returnState("testList");
        }
    },
    SEARCH {
        @Override
        public void execute() {
            executive.returnState("search");

            MenuOption.LIST.execute();
        }
    },

    COUNT {
        @Override
        public void execute() {
            executive.returnState("count");
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
