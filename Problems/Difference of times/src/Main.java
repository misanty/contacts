 import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] times = new int[2][3];


        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 2; j++) {
                String val = scanner.next();
                if (val.matches("\\d+")) {
                    times[i][j] = Integer.parseInt(val);
                }
            }
        }
        System.out.println(calc(times));

    }

    static int calc(int[][] arr) {
        int val = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                switch (j) {
                    case 0:
                        val = (arr[i + 1][j] - arr[i][j]) * 3600;
                        break;
                    case 1:
                        val += (arr[i + 1][j] - arr[i][j]) * 60;
                        break;
                    case 2:
                        val += arr[i + 1][j] - arr[i][j];
                        break;
                    default:
                }


            }
        }
        return val;
    }
}
