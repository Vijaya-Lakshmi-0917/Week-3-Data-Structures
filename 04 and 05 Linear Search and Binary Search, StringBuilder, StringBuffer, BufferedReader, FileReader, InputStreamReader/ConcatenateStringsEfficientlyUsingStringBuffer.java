public class ConcatenateStringsEfficientlyUsingStringBuffer {
    public static String concatenateStrings(String[] strings) {
        StringBuffer sb = new StringBuffer();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String[] words = {"This", " ", "is", " ", "a"," ","java"," ","program","."};
        String result = concatenateStrings(words);
        System.out.println("Concatenated string: " + result);
    }
}