//put imports you need here


import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        String[] strArray = new String[3];
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        do {
            strArray[count] = scanner.nextLine();
            count++;
        } while (count < 3);
        for (int i = strArray.length - 1; i >= 0; i--) {
            System.out.println(strArray[i]);

        }
    }
}