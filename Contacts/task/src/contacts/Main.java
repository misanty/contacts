package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Contacts> contactsList;


    public static void main(String[] args) {
        Contacts contacts;
        AbstractRecord record;
        contactsList = new ArrayList<>();
        Scanner scanner;
        String value;
        Action action;
        int cnt = 1;
        ActionExecutor executor = new ActionExecutor();
        ActionReceiver receiver;
        

        do {
            System.out.println("Enter action (add, remove, edit, count, list, exit):");
            scanner = new Scanner(System.in);
            value = scanner.next();
            try {
                action = Action.valueOf(value.toUpperCase());
            } catch (IllegalArgumentException e) {
                action = Action.INVALID;
            }


            switch (action) {
                case ADD:
                    AbstractRecord abstractRecordInitialization;
                    do {
                        System.out.println("Enter the type (person, organization): ");
                        String type = scanner.next();
                        abstractRecordInitialization = new InitializationRecordTypeFactory().createRecordType(type);
                        if (abstractRecordInitialization != null) {
                            receiver = new ActionReceiver(abstractRecordInitialization, scanner);

                            AddAction addAction = new AddAction(receiver);

                            executor.executeOperation(addAction);
                        }
                    } while (abstractRecordInitialization != null && AbstractRecord.getRecordList().size() <= 0);



                    // AbstractRecord.getRecordList().forEach(abstractRecord -> System.out.println(abstractRecord.toString()));
                    // AbstractRecord.getRecordList().remove(1);



                    /*abstractRecordList.add(record);
                    for (AbstractRecord person : abstractRecordList) {
                        Person person1 = (Person) person;
                        System.out.println(person1.toString());
                    }*/
                    //TODO Change the business logic into above example :)

                    /*contacts = new Contacts();
                    System.out.print("Enter the name: ");
                    contacts.setName(scanner.next());
                    System.out.print("Enter the surname: ");
                    contacts.setSurname(scanner.next());
                    System.out.print("Enter the number: ");
                    scanner = new Scanner(System.in);

                    contacts.setPhoneNumber(scanner.nextLine());
                    if (!contacts.HasNumber()) {
                        System.out.println("Wrong number format!");
                    }
                    contacts.setId(cnt);
                    contactsList.add(contacts);
                    System.out.println("The record added.");
*/
                    break;
                case EDIT:



                    if (contactsList.size() > 0) {
                        int id;
                        String val;
                        contactsList.forEach(contacts1 -> System.out.println(contacts1.toString()));
                        System.out.print("Select a record: ");
                        scanner = new Scanner(System.in);
                        id = scanner.nextInt();
                        System.out.print("Select a field (name, surname, number): ");
                        val = scanner.next();

                        if ("name".equals(val)) {
                            System.out.print("Enter name: ");

                            contactsList.get(getIndexOf(id, contactsList)).setName(scanner.next());
                        } else if ("surname".equals(val)) {
                            System.out.print("Enter surname: ");

                            contactsList.get(getIndexOf(id, contactsList)).setSurname(scanner.next());
                        } else if ("number".equals(val)) {
                            System.out.print("Enter number: ");
                            scanner = new Scanner(System.in);
                            contactsList.get(getIndexOf(id, contactsList)).setPhoneNumber(scanner.nextLine());
                            if (!contactsList.get(getIndexOf(id, contactsList)).HasNumber()) {
                                System.out.println("Wrong number format!");
                            }
                            System.out.println("The record updated!");
                        } else {
                            return;
                        }


                    } else {
                        System.out.println("No records to edit!");
                    }

                    break;
                case LIST:
                    AbstractRecord.getRecordList().forEach(abstractRecord -> System.out.println(abstractRecord.toString()));
                    ////////////////////////////
                    //contactsList.forEach(contacts1 -> System.out.println(contacts1.toString()));
                    break;
                case COUNT:
                    System.out.println("The Phone Book has " + contactsList.size() + " records.");
                    break;
                case REMOVE:
                    int id;
                    AbstractRecord.getRecordList().remove(0);
                    if (contactsList.size() > 0) {
                        contactsList.forEach(contact -> System.out.println(contact.toString()));
                        System.out.print("Select a record: ");
                        id = getIndexOf(scanner.nextInt(), contactsList);
                        contactsList.remove(id);
                        if (contactsList.size() > 0 && id < contactsList.size()) {

                            for (int i = contactsList.size(); i > id; --i) {

                                contactsList.get(i - 1).setId(i);

                            }
                            cnt = contactsList.size() - 1;
                        }
                        System.out.println("The record removed!");
                    } else {
                        System.out.println("No records to remove!");
                    }

                    break;
                case EXIT:
                case INVALID:
                    break;
            }

            scanner.reset();
            if (action != Action.INVALID)
                cnt++;
        } while (!value.equals("exit"));


    }

    public static int getIndexOf(int id, List<Contacts> contacts) {
        int cnt = 0;

        for (Contacts contact : contacts) {
            if (id == contact.getId())
                return cnt;
            cnt++;
        }

        return -1;
    }

    public enum Action {
        ADD,
        REMOVE,
        EDIT,
        COUNT,
        LIST,
        INVALID,
        EXIT;

        @Override
        public String toString() {
            return name().toLowerCase();
        }
    }


}

class Initilizer {
    static List<Contacts> contactsList = new ArrayList<>();

    public enum Action {
        ADD,
        REMOVE,
        EDIT,
        COUNT,
        LIST,
        INVALID,
        EXIT;

        @Override
        public String toString() {
            return name().toLowerCase();
        }
    }

    static Action action;
    AbstractRecord mContacts;
    Scanner mScanner;
    static int cnt = 0;


    public Initilizer() {
        String value;
        System.out.println("Enter action (add, remove, edit, count, list, exit):");
        mScanner = new Scanner(System.in);
        value = mScanner.next();
        try {
            action = Action.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            action = Action.INVALID;
        }
    }

    public void add() {
        /*
         * TODO Slice and dice the entire switch statements into this class by turning them into individual methods
         *
         *  */
    }

    public static int getIndexOf(int id, List<Contacts> contacts) {
        int cnt = 0;

        for (Contacts contact : contacts) {
            if (id == contact.getId())
                return cnt;
            cnt++;
        }

        return -1;
    }


}





