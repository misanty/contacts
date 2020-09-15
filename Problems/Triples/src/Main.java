
import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        int[] triplet = java.util.Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int count = 0;

        for (int i = 0; i < triplet.length - 2; i++) {
            if (triplet[i] == triplet[i + 1] - 1 && triplet[i] == triplet[i + 2] - 2) {
                count++;
            }

        }
        System.out.println(count);

    }
}