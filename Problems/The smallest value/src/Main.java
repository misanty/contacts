import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long m = scanner.nextLong();
        long n = 1;

        int count = 2;
        while (n <= m) {
            n = n * count;
            if (n > m) {
                System.out.println(count);
            }
            count++;

        }


    }
}