import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        int[] array = Arrays.stream(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (array.length >= 2)
            System.out.println(Math.multiplyExact(array[0], array[1]));


    }
}