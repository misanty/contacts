import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int cnt = 1;
        int[] a = new int[l];
        while (cnt <= l) {
            if (cnt < l) {
                a[cnt] = scanner.nextInt();
            }
            if (cnt == l) {
                a[0] = scanner.nextInt();
            }
            cnt++;
        }
        for (int i : a) {
            System.out.print(i + " ");
        }

    }
}