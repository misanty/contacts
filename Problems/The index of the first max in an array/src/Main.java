import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.nextLine();
        int[] arrayInput = Arrays.stream(sc.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int maxVal = -1;
        int ind = -1;
        for (int i = 0; i < arrayInput.length; i++) {
            if ( arrayInput[i] > maxVal) {
                maxVal = arrayInput[i];
                ind = i;
            }

        }
        System.out.println(ind);

    }
}