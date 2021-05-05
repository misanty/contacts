import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[3];
        int i = 0;
        while (scanner.hasNext()) {
            arr[i] = scanner.nextInt();
            i++;
        }


        if (arr[0] <= arr[2] && arr[2] <= arr[1]) {
            System.out.println("Normal");
        } else if (arr[0] > arr[2]) {
            System.out.println("Deficiency");
        } else {
            System.out.println("Excess");
        }

    }
}