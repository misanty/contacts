import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        System.out.println(passwordCheck(password) ? "YES" : "NO");


    }

    public static boolean passwordCheck(String password) {
        return password.matches("^(?=.*[\\w]{12,})(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d]).+$");
    }
}