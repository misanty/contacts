import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String val = scanner.next();
        System.out.println(returnVal(val));


    }

    private static int returnVal(String val) {
        int value = 0;
        switch (val) {

            case "one":
                return value = 1;

            case "two":
                return value = 2;

            case "three":
                return value = 3;

            case "four":
                return value = 4;

            case "five":
                return value = 5;

            case "six":
                return value = 6;

            case "seven":
                return value = 7;

            case "eight":
                return value = 8;

            case "nine":
                return value = 9;

            default:
                break;
        }

        return value;
    }


}
