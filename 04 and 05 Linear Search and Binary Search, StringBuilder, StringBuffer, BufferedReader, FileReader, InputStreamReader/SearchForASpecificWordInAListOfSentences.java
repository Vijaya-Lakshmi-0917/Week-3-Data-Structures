public class SearchForASpecificWordInAListOfSentences {
    public static void main(String[] args) {
        String[] sentences = {
                "Java is a programming language.",
                "This is a java program"
        };

        String word = "programming";
        String result = findSentenceContainingWord(sentences, word);

        System.out.println(result);
    }

    public static String findSentenceContainingWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }
}