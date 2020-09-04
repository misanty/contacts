import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double m = scanner.nextDouble();
        double p = scanner.nextDouble();
        double k = scanner.nextDouble();

        if (m <= k) {
            System.out.println();
            System.out.println((int) Math.ceil(calculate(m, p, k)));
        }

        scanner.close();
    }

    public static double calculate(double m, double p, double k) {
        double logBase;
        logBase = (m + (m * (p * 0.01)));
        return Math.log(k) / Math.log(logBase);
    }
}