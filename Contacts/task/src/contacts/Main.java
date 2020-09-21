package contacts;

import java.util.Scanner;

public class Main {
    static ActionReceiver receiver;

    public static void main(String[] args) {
        initialize();


    }

    public static void initialize() {
        Scanner scanner;
        String input;
        ActionEnum.Action action;
        boolean status;
        ActionExecutor executor = new ActionExecutor();

        do {
            System.out.println("Enter action (add, remove, edit, count, info, exit):");
            scanner = new Scanner(System.in);
            input = scanner.next().trim().toUpperCase();
            scanner.reset();
            try {
                action = ActionEnum.Action.valueOf(input);
                status = true;
            } catch (IllegalArgumentException e) {
                action = ActionEnum.Action.EXIT;
                status = false;
            }

            if (action == ActionEnum.Action.ADD) {
                AbstractRecord abstractRecordInitialization;
                do {
                    System.out.println("Enter the type (person, organization): ");
                    String type = scanner.next();
                    abstractRecordInitialization = new InitializationRecordTypeFactory().createRecordType(type);
                    if (abstractRecordInitialization != null) {
                        receiver = new ActionReceiver(abstractRecordInitialization, scanner);
                        ActionEnum addAction = new ActionEnum(ActionEnum.Action.ADD, receiver);
                        executor.executeOperation(addAction);
                    }
                } while (abstractRecordInitialization != null && AbstractRecord.getRecordList().size() <= 0);
            } else if (status) {
                if (receiver != null) {
                    ActionEnum addAction = new ActionEnum(ActionEnum.Action.valueOf(input), receiver);
                    executor.executeOperation(addAction);

                } else if (!"EXIT".equals(input) && !"COUNT".equals(input)) {
                    System.out.println("No records to " + input.toLowerCase() + "!");
                }
                if(receiver == null)
                switch (action) {
                    case COUNT:
                        System.out.println("The Phone Book has 0 records.");
                        break;
                    case EXIT:
                        break;
                }
            }
            System.out.println();
            scanner.reset();

        } while (!"EXIT".equals(input));
    }


}






