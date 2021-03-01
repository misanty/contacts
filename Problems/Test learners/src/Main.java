import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String out = "";
        switch (scanner.nextInt()) {
            case 1:
                out = "Yes!";
                break;
            case 2:
            case 3:
            case 4:
                out = "No!";
                break;
            default:
                out = "Unknown number";
                break;

        }
        System.out.println(out);

    }
}