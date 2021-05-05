import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        int[] message = new int[] {114, 101, 97, 100, 32, 97, 98, 111, 117, 116, 32, 65, 83, 67, 73, 73};

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        for (int code : message) {
            outputStream.write(code);
        }

        System.out.println(outputStream.toString());

/*
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        int p = -1;
        boolean check = false;
        int[] arr = Arrays.stream(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i : arr
        ) {
            if (i > p) {
                p = i;
                check = true;
            } else {
                check = false;
                break;
            }
        }
        System.out.println(check);

        char ch = 65;
        System.out.println(ch);
*/

    }
}