import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] elements = new int[scanner.nextInt()];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = scanner.nextInt();
        }
        System.out.println(maxElementDivisibleBy4(elements));


    }

    private static int maxElementDivisibleBy4(int[] elements) {
        int previous = 0;
        for (int element : elements) {
            if (element % 4 == 0 && previous < element) {
                previous = element;
            }
        }
        return previous;
    }
    private static int maxElementDivisibleBy4Lambda(int[] elements) {
        int previous = 0;

        //Arrays.stream(elements).forEach();

        return previous;
    }
}