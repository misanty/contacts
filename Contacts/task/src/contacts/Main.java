package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Contacts> contactsList;

    public static void main(String[] args) {
        Contacts contacts;
        contactsList = new ArrayList<>();
        Scanner scanner;
        String value;
        Action action;
        int cnt = 1;
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
                    contacts = new Contacts();
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
                    contactsList.forEach(contacts1 -> System.out.println(contacts1.toString()));
                    break;
                case COUNT:
                    System.out.println("The Phone Book has " + contactsList.size() + " records.");
                    break;
                case REMOVE:
                    //TODO Add remove
                    if (contactsList.size() > 0) {
                        contactsList.forEach(contact -> System.out.println(contact.toString()));
                        System.out.print("Select a record: ");
                        contactsList.remove(getIndexOf(scanner.nextInt(), contactsList));
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
