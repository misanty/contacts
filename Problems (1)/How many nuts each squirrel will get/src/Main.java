import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        if(n <= 10000 && k <= 10000)
        {
            int ret = k / n;
            System.out.println(ret);
        }


    }
}