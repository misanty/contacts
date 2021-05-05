import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();

        // write your code here

        String stringPattern = "^.*(?:\\b[a-zA-Z]{" + size + "}\\b).*$";
        System.out.println(Pattern.matches(stringPattern, line) ? "YES" : "NO");
        char ch = '\u0031' + '\u0035';
        System.out.println(ch);


    }
}