import java.time.LocalDate;

import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        LocalDate date = LocalDate.ofYearDay(2018, 2);
        date = LocalDate.of(2018, 1, 1).withDayOfMonth(1);
        System.out.println(LocalDate.of(2018, 3, 2).minusMonths(2));
        System.out.println(LocalTime.now().getNano());
        System.out.println("question: "+LocalTime.MIDNIGHT);

        System.out.println(LocalTime.of(0,1,1,999999));

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