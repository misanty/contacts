import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inp = scanner.nextInt();
        int total = (int) Math.pow(inp, 2);
        int[][] multiDimArr = new int[inp][inp];
        int cnt = 1;
        int i = 0;
        int j = 0;
        int startFrom = 0;
        int len = multiDimArr.length - 1;
        while (cnt <= total) {


            while (j < len && i < len && cnt != total) {
                multiDimArr[i][j] = cnt++;
                j++;
                if (j == len) {
                    while (i < j) {
                        multiDimArr[i][j] = cnt++;
                        i++;
                    }
                }
                if (i == j) {
                    while (startFrom < j) {

                        multiDimArr[i][j] = cnt++;
                        j--;
                    }


                }
            }
            if (j == startFrom && i == len && len > 0) {
                startFrom++;
                len--;
                while (startFrom <= i) {

                    multiDimArr[i][j] = cnt++;
                    i--;

                }
                i = startFrom;
                j = startFrom;

            }
            if (cnt == total) {
                multiDimArr[i][j] = cnt++;
                j++;
            }

        }

        for (int[] elements : multiDimArr) {
            for (var element : elements
            ) {
                System.out.print(element + " ");
            }
            System.out.println();
        }


    }
}