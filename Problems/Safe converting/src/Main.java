import java.util.Scanner;

public class Main {

    public static int convert(Long val) {
        int val2;
        if (val == null) {
            val2 = 0;
        } else if (val > Integer.MAX_VALUE) {
            val2 = Integer.MAX_VALUE;
        } else if (val < Integer.MIN_VALUE) {
            val2 = Integer.MIN_VALUE;
        } else {
            val2 = val.intValue();
        }
        return val2;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String val = scanner.nextLine();
        Long longVal = "null".equals(val) ? null : Long.parseLong(val);
        System.out.println(convert(longVal));
    }
}