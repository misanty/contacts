class Problem {
    public static void main(String[] args) {
        int count = 0;
        for (var cnt : args) {

            if ("test".equals(cnt)) {
                System.out.println(count);
                break;
            } else if (count == args.length - 1) {
                count = -1;
                System.out.println(count);
            }
            count++;

        }

    }
}