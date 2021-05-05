import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here

        System.out.println(Arrays.stream(reader.readLine().trim().split("\\s+")).filter(s -> !s.isBlank()).count());
        reader.close();
    }

   /* public static List<File> getAllFiles(File rootDir) {
        File[] children = rootDir.listFiles();
        if (children == null || children.length == 0) {
            return Collections.emptyList();
        }

        List<File> files = new ArrayList<>();
        for (File child : children) {
            if (child)
        }

    }*/
}