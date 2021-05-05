import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int next = 0;
        int pre = -1;
        while (scanner.hasNext()) {
           if (pre < (next = scanner.nextInt())) {
                pre = next;
            }
            if(next == 0)
                break;
        }
        System.out.println(pre);

    }
}