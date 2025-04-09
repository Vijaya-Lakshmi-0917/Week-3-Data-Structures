import java.io.*;
public class CompareStringBuilderStringBufferFileReaderAndInputStreamReader {
    public static void main(String[] args) {
        compareStringBuilderAndBuffer();
        compareFileReaderAndInputStreamReader("C:\\Users\\S Vijaya Lakshmi\\documents\\Java.txt");
    }

    private static void compareStringBuilderAndBuffer() {
        String sample = "hello";
        int iterations = 1_000_000;

        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(sample);
        }
        long sbTime = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sf.append(sample);
        }
        long sfTime = System.currentTimeMillis() - startTime;

        System.out.println("StringBuilder time: " + sbTime + " ms");
        System.out.println("StringBuffer time:  " + sfTime + " ms");
    }

    private static void compareFileReaderAndInputStreamReader(String filePath) {
        try {
            long startTime = System.currentTimeMillis();
            int wordCountFR = countWordsUsingFileReader(filePath);
            long frTime = System.currentTimeMillis() - startTime;

            startTime = System.currentTimeMillis();
            int wordCountISR = countWordsUsingInputStreamReader(filePath);
            long isrTime = System.currentTimeMillis() - startTime;

            System.out.println("\nFileReader - Word Count: " + wordCountFR + ", Time: " + frTime + " ms");
            System.out.println("InputStreamReader - Word Count: " + wordCountISR + ", Time: " + isrTime + " ms");

        } catch (IOException e) {
            System.out.println("Error reading file:");
            e.printStackTrace();
        }
    }

    private static int countWordsUsingFileReader(String filePath) throws IOException {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count += line.trim().isEmpty() ? 0 : line.trim().split("\\s+").length;
            }
        }
        return count;
    }

    private static int countWordsUsingInputStreamReader(String filePath) throws IOException {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count += line.trim().isEmpty() ? 0 : line.trim().split("\\s+").length;
            }
        }
        return count;
    }
}
