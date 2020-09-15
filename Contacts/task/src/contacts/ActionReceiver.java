package contacts;

import java.util.Scanner;

/**
 * This is the Receiver Class
 */
public class ActionReceiver {
    private final AbstractRecord mRecord;
    private Scanner mScanner;
    private boolean isPerson = false;


    public ActionReceiver(AbstractRecord initializeRecord, Scanner scanner) {
        mRecord = initializeRecord;
        isPerson = mRecord.getClass() != null && "Person".equals(mRecord.getClass().getSimpleName());
        mScanner = scanner;
    }

    public AbstractRecord add() {
        if (isPerson) {
            Person contacts = (Person) mRecord;
            System.out.print("Enter the name: ");
            mScanner = new Scanner(System.in);
            contacts.setName(mScanner.nextLine());
            System.out.print("Enter the surname: ");
            contacts.setLastName(mScanner.nextLine());
            System.out.print("Enter the birth date: ");
            contacts.setBirthday(mScanner.next());
            System.out.print("Enter the gender (M, F): ");
            contacts.setGender(mScanner.next());
            /*TODO You should think something else for the Gender field, you should either consider it to change it into String or enum or boolean
             */

        } else {
            Organization organization = (Organization) mRecord;
            System.out.print("Enter the organization name: ");
            mScanner = new Scanner(System.in);
            organization.setName(mScanner.nextLine());
            System.out.print("Enter the address:");
            organization.setAddress(mScanner.nextLine());

        }

        System.out.print("Enter the number: ");
        mScanner = new Scanner(System.in);
        AbstractRecord contacts = mRecord;
        contacts.setPhoneNumber(mScanner.nextLine());
        if (!contacts.HasNumber()) {
            System.out.println("Wrong number format!");
        }

        System.out.println("The record added.");
        return mRecord;
    }

    public AbstractRecord edit() {
        //TODO Add edit
        return mRecord;
    }

    public AbstractRecord remove() {
        //TODO Add remove
        return mRecord;
    }

    public AbstractRecord count() {
        //TODO Add count
        return mRecord;
    }

    public AbstractRecord info() {
        //TODO Add info
        return mRecord;
    }


}
