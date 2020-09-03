import java.util.*;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String ip = scanner.next();
        String pat = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        String compPat = String.join("\\.", pat, pat, pat, pat);

        System.out.println(ip.matches(compPat) ? "YES" : "NO");

    }
}
