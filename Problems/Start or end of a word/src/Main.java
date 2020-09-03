import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();

        Pattern pattern = Pattern.compile(".*\\b((?is)" + part + ").*|.*((?is)" + part + ")\\b.*");
        Matcher matcher = pattern.matcher(line);
        System.out.println(matcher.matches() ? "YES" : "NO");

         /* double returnVal =
       if (Math.ceil(returnVal) != returnVal) {
            returnVal = returnVal + (double) 1;
        }*/

    }
}