package contacts;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * This is the Receiver Class
 */
public class ActionReceiver {
    private final AbstractRecord mRecord;
    private static Scanner mScanner;
    private boolean isPerson = false;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public ActionReceiver(AbstractRecord initializeRecord, Scanner scanner) {
        mRecord = initializeRecord;
        isPerson = mRecord.getClass() != null && "Person".equals(mRecord.getClass().getSimpleName());
        mScanner = scanner;
        status = true;
    }

    public AbstractRecord add() {
        if (isPerson) {

            Person contacts = (Person) mRecord;
            System.out.print("Enter the name: ");
            mScanner = new Scanner(System.in);
            String name = mScanner.nextLine();
            mScanner.reset();
            contacts.setName(name);
            System.out.print("Enter the surname: ");
            contacts.setLastName(mScanner.nextLine());
            System.out.print("Enter the birth date: ");
            String birth = mScanner.nextLine();
            mScanner.reset();
            contacts.setBirthday(birth);
            if (!contacts.hasBirthday()) {
                System.out.println("Bad birth date!");
            }
            System.out.print("Enter the gender (M, F): ");
            String gender = mScanner.nextLine();
            mScanner.reset();
            contacts.setGender(gender);

            if (!contacts.hasGender()) {
                System.out.println("Bad gender!");
            }


        } else {
            Organization organization = (Organization) mRecord;
            System.out.print("Enter the organization name: ");
            mScanner = new Scanner(System.in);
            organization.setName(mScanner.nextLine());
            mScanner.reset();
            System.out.print("Enter the address: ");
            organization.setAddress(mScanner.nextLine());
            mScanner.reset();

        }

        System.out.print("Enter the number: ");
        mScanner = new Scanner(System.in);
        AbstractRecord contacts = mRecord;
        contacts.setPhoneNumber(mScanner.nextLine());
        if (!contacts.HasNumber()) {
            System.out.println("Wrong number format!");
        }
        contacts.setDateTimeLastEdit(LocalDateTime.now());
        System.out.println("The record added.");
        status = true;
        return mRecord;
    }

    public AbstractRecord edit() {
        ActionsEnumList actionsEnumList;
        if (AbstractRecord.getRecordList().size() > 0) {
            String scannerStr;
            showList();
            System.out.println("Select a record: ");
            mScanner = new Scanner(System.in);

            int id = inputTryCatch(mScanner);
            AbstractRecord parent = AbstractRecord.getRecordList().get(id - 1);

            if (parent instanceof Person) {
                isPerson = true;
                System.out.println("Select a field (name, surname, birth, gender, number): ");

            } else {
                isPerson = false;
                System.out.print("Select a field (organization name, address, number): ");
            }
            mScanner = new Scanner(System.in);
            String val = mScanner.nextLine();
            try {
                actionsEnumList = ActionsEnumList.valueOf(val.trim().toUpperCase().replaceAll("\\s", "_"));
            } catch (IllegalArgumentException e) {
                actionsEnumList = ActionsEnumList.INVALID;
            }


            this.status = true;


            switch (actionsEnumList) {
                case NAME:
                case ORGANIZATION_NAME:
                    scannerStr = actionsEnumList.returnVal();
                    parent.setName(scannerStr);
                    break;
                case SURNAME:
                    scannerStr = actionsEnumList.returnVal();
                    AbstractRecord record = AbstractEdit.editPerson(parent, AbstractEdit.PersonEdit.LASTNAME, scannerStr);
                    AbstractRecord.getRecordList().set(id - 1, record);
                    break;
                case BIRTH:
                    scannerStr = actionsEnumList.returnVal();
                    AbstractRecord.getRecordList().set(id - 1, AbstractEdit.editPerson(parent, AbstractEdit.PersonEdit.BIRTH, scannerStr));
                    break;
                case GENDER:
                    scannerStr = actionsEnumList.returnVal();
                    Person person;
                    AbstractRecord.getRecordList().set(id - 1, person = AbstractEdit.editPerson(parent, AbstractEdit.PersonEdit.GENDER, scannerStr));
                    if (!person.hasGender())
                        System.out.println("Bad gender!");

                    break;
                case NUMBER:
                    scannerStr = actionsEnumList.returnVal();
                    parent.setPhoneNumber(scannerStr);
                    if (!parent.HasNumber()) {
                        System.out.println("Wrong number format!");
                    }

                    break;
                case ADDRESS:
                    scannerStr = actionsEnumList.returnVal();
                    AbstractRecord.getRecordList().set(id - 1, AbstractEdit.editOrganization(AbstractRecord.getRecordList().get(id - 1), AbstractEdit.OrganizationEdit.ADDRESS, scannerStr));
                    break;
                case INVALID:
                    this.status = false;
                    break;

            }
            parent.setDateTimeLastEdit(LocalDateTime.now());
            System.out.println("The record updated!");
        } else {
            System.out.println("No records to edit!");

        }
        return mRecord;
    }

    public AbstractRecord remove() {

        if (AbstractRecord.getRecordList().size() > 0) {
            showList();
            System.out.print("Select a record: ");
            int id = inputTryCatch(mScanner);

            AbstractRecord.getRecordList().remove(id - 1);
            System.out.println("The record removed!");
            this.status = true;
        } else {
            System.out.println("No records to remove!");

        }
        return mRecord;
    }

    public AbstractRecord count() {

        System.out.println("The Phone Book has " + AbstractRecord.getRecordList().size() + " records.");
        return mRecord;
    }

    public AbstractRecord info() {
        int id = 0;
        if (AbstractRecord.getRecordList().size() > 0) {
            showList();
            System.out.println("Enter index to show info: ");
            mScanner = new Scanner(System.in);
            try {
                id = inputTryCatch(mScanner);

                isPerson = AbstractRecord.getRecordList().get(id - 1) instanceof Person;
                this.status = true;
            } catch (IndexOutOfBoundsException e) {

                this.status = false;
            }
            if (isStatus()) {
                if (isPerson) {
                    Person person = (Person) AbstractRecord.getRecordList().get(id - 1);
                    System.out.println(person.toString());
                } else {
                    Organization organization = (Organization) AbstractRecord.getRecordList().get(id - 1);
                    System.out.println(organization.toString());
                }

            }
        } else {
            System.out.println("No records to list!");
        }

        return mRecord;
    }

    public AbstractRecord exit() {
        this.status = false;
        return mRecord;
    }

    private void showList() {
        for (int i = 1; i <= AbstractRecord.getRecordList().size(); i++) {
            AbstractRecord record = AbstractRecord.getRecordList().get(i - 1);
            if (record instanceof Person) {
                Person person = (Person) AbstractRecord.getRecordList().get(i - 1);
                System.out.println(i + ". " + person.getName() + " " + person.getLastName());
            } else {
                System.out.println(i + ". " + AbstractRecord.getRecordList().get(i - 1).getName());
            }

        }
    }

    enum ActionsEnumList {
        NAME {
            @Override
            String returnVal() {
                System.out.print("Enter name: ");
                mScanner = new Scanner(System.in);
                return mScanner.nextLine();
            }
        },
        SURNAME {
            @Override
            String returnVal() {
                System.out.print("Enter surname: ");
                mScanner = new Scanner(System.in);
                return mScanner.nextLine();

            }
        },
        BIRTH {
            @Override
            String returnVal() {
                System.out.print("Enter birthday: ");
                mScanner = new Scanner(System.in);
                return mScanner.nextLine();
            }
        },
        GENDER {
            @Override
            String returnVal() {
                System.out.print("Enter gender: ");
                mScanner = new Scanner(System.in);
                return mScanner.nextLine();
            }
        },
        NUMBER {
            @Override
            String returnVal() {
                System.out.print("Enter number: ");
                mScanner = new Scanner(System.in);
                return mScanner.nextLine();
            }
        },
        ORGANIZATION_NAME {
            @Override
            String returnVal() {
                System.out.print("Enter the organization name: ");
                mScanner = new Scanner(System.in);
                return mScanner.nextLine();
            }

            @Override
            public String toString() {
                return "organization name";
            }
        },
        ADDRESS {
            @Override
            String returnVal() {
                System.out.print("Enter the address: ");
                mScanner = new Scanner(System.in);
                return mScanner.nextLine();
            }
        },
        INVALID {
            @Override
            String returnVal() {
                return "";
            }
        };


        abstract String returnVal();

        @Override
        public String toString() {
            return name().toLowerCase();
        }
    }


    private int inputTryCatch(Scanner input) {
        int i = 0;

        try {
            i = input.nextInt();
            this.status = true;
        } catch (InputMismatchException e) {
            this.status = false;
        }
        return i;
    }


}
