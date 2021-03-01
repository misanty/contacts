package menu;
import inputController.RepositoryCrud;

import java.util.Scanner;

public class ExecuteCrud {

    //TODO Add menu functionality and consider the newly changed requirements about it.
    private static Scanner scanner = new Scanner(System.in);
    private static ExecuteCrud executeCrudInstance;
    private final RepositoryCrud crud;

    public static ExecuteCrud getInstance(RepositoryCrud crud) {
        if (executeCrudInstance == null) {
            executeCrudInstance = new ExecuteCrud(crud);
        }
        return executeCrudInstance;
    }

    private ExecuteCrud(RepositoryCrud crud) {
        this.crud = crud;

    }

    protected void add() {
        System.out.println("I'm from enum ADD");
    }

    protected void edit() {

    }

    protected boolean search() {
        System.out.println("Enter search query: ");
        return false;
        /**
         * TODO return true if the user says again, and false
         *
         *
         */


    }


    private String readWriteFieldName(String fieldName) {
        System.out.print("Enter the " + fieldName + ": ");
        return scanner.nextLine();
    }


}
