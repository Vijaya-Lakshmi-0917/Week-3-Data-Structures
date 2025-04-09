public class ReverseAStringUsingStringBuilder {
    public static String reverseString(String input) {
        StringBuilder sb = new StringBuilder(input);
        sb.reverse();
        return sb.toString();
    }
    public static void main(String[] args) {
        String input = "hello";
        String reversed = reverseString(input);

        System.out.println("Reversed string: " + reversed);
    }
}