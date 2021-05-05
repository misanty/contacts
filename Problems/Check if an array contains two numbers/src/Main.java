import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String strArray = sc.nextLine();
        String search = sc.nextLine();


        int[] arrayRepo;
        int[] arraySearch;

        arrayRepo = Arrays.stream(strArray.trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        arraySearch = Arrays.stream(search.trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean check;


        check = indexOfIntArray(arrayRepo, arraySearch[0], arraySearch[1]) != -1;

        System.out.println(check);


    }

    static int indexOfIntArray(int[] array, int key1, int key2) {
        int returnValue = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key1) {
                for (int j = array.length - 1; j >= 0; j--) {
                    if (array[j] == key2 && Math.abs(j - i) == 1) {
                        returnValue = j;
                        return returnValue;
                    }
                }
            }
        }
        return returnValue;
    }

}
