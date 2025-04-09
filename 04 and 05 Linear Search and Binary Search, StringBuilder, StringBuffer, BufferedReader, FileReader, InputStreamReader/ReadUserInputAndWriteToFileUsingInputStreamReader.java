import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.IOException;
public class ReadUserInputAndWriteToFileUsingInputStreamReader {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\S Vijaya Lakshmi\\documents\\Java.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(filePath)) {

            String inputLine;

            System.out.println("Enter text to write to the file (type 'exit' to finish):");
            while ((inputLine = reader.readLine()) != null) {
                if (inputLine.equalsIgnoreCase("exit")) {
                    break;
                }
                writer.write(inputLine + System.lineSeparator());
            }

            System.out.println("Input has been written to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred:");
            e.printStackTrace();
        }
    }
}
