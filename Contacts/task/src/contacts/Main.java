package contacts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    static ActionReceiver receiver;

    public static void main(String[] args) {
        //initialize();

        String path = "./Desktop/Head First Design Patterns ( PDFDrive.com ).pdf";
        File file = new File(path);
        System.out.println("File name: " + file.getName());
        System.out.println("File path: " + file.getPath());
        System.out.println("Is file: " + file.isFile());
        System.out.println("Is directory: " + file.isDirectory());
        System.out.println("Exists: " + file.exists());
        System.out.println("Can read:" + file.canRead());
        // System.out.println(calc(file));


    }

    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    private static int calc(File file) {
        int count = 0;


        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                if (sc.nextInt() % 2 == 0) {
                    count++;
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist.");
        } catch (NumberFormatException e) {
            System.out.println("The file contains non numeric data.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return 0;
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






