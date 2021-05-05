import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        Stream<String> streamArrayElements = Arrays.stream(scanner.nextLine().trim().split("\\s+"));
        int val = scanner.nextInt();
        int sum = streamArrayElements.mapToInt(Integer::parseInt)
                .filter(num -> num > val)
                .sum();

        System.out.println(sum);

    }
}