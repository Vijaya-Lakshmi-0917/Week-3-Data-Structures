import java.util.HashSet;
public class RemoveDuplicatesFromAStringUsingStringBuilder {
    public static String removeDuplicates(String input) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!seen.contains(c)) {
                sb.append(c);
                seen.add(c);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String input = "programming";
        String result = removeDuplicates(input);
        System.out.println("String without duplicates: " + result);
    }
}