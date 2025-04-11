import java.io.*;
public class LargeFileReadingEfficiently {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\S Vijaya Lakshmi\\documents\\Java.txt";
        long start = System.nanoTime();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
            }
        }
        long end = System.nanoTime();
        System.out.printf("FileReader Time: %.2f ms%n", (end - start) / 1_000_000.0);
        start = System.nanoTime();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            while (reader.readLine() != null) {
            }
        }
        end = System.nanoTime();
        System.out.printf("InputStreamReader Time: %.2f ms%n", (end - start) / 1_000_000.0);
    }
}