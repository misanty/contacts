import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] triplet = java.util.Arrays.stream(scanner.nextLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        int result = 0;
        for (int digit : triplet) {
            result += digit;
        }
        System.out.println(result);
    }
}