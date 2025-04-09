import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class CountTheOccurrenceOfAWordInAFileUsingFileReader {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\S Vijaya Lakshmi\\documents\\Java.txt";
        String targetWord = "java";
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
            System.out.println("The word \"" + targetWord + "\" appears " + count + " times in the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file:");
            e.printStackTrace();
        }
    }
}