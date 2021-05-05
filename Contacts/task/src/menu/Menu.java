package menu;

import java.util.Scanner;
import java.util.stream.Collectors;


public class Menu implements Executive {
    static ExecuteCrud mExecuteCrud;
    static Scanner scanner = new Scanner(System.in);
    static boolean status;
    static Menu instance;


    public Menu(ExecuteCrud executeCrud) {
        mExecuteCrud = executeCrud;
        status = true;
        instance = this;
    }

    protected static Menu getInstance() {
        return instance;
    }

    @Override
    public void execute() {
        while (status) {
            selectAndExecute();
        }

    }

    @Override
    public ExecuteCrud init() {
        return mExecuteCrud;
    }

    @Override
    public void returnState(String str) {
        System.out.println(str);


    }

    protected static void exit() {
        status = false;
    }

    private void printList() {
        String output = "[menu] Enter Action(" +
                MenuOption.stream()
                        .map(MenuOption::toString)
                        .collect(Collectors.joining(", "))
                + "): ";
        System.out.println(output);
    }

    private void selectAndExecute(){
        printList();
        String input = scanner.nextLine().trim().toUpperCase();
        MenuOption.stream()
                .filter(item -> item.name().equals(input))
                .findFirst()
                .ifPresent(MenuOption::execute);
    }

}
