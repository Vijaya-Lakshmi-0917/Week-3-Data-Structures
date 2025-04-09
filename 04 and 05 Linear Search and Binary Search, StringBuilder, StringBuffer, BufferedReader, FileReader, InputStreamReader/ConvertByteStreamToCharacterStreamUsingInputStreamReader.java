import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class ConvertByteStreamToCharacterStreamUsingInputStreamReader {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\S Vijaya Lakshmi\\documents\\Java.txt";

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file:");
            e.printStackTrace();
        }
    }
}
