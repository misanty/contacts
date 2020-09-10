import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        System.out.println(passwordCheck(password) ? "YES" : "NO");


    }

    public static boolean passwordCheck(String password) {
        /**
         * (?=.*[a-z])        // use positive look ahead to see if at least one lower case letter exists
         * (?=.*[A-Z])        // use positive look ahead to see if at least one upper case letter exists
         * (?=.*\d)           // use positive look ahead to see if at least one digit exists
         * (?=.*\W])        // use positive look ahead to see if at least one non-word character exists
         * \W might be a bit broad. I'd replace it with a character set like this: [-+_!@#$%^&*.,?]
         */
        return password.matches("^(?=.*[\\w]{12,})(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d]).+$");
    }
}