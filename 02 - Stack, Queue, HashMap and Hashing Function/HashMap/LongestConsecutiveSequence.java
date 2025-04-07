import java.util.HashSet;
public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] num) {
        if (num.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int number : num) {
            set.add(number);
        }
        int longestStreak = 0;
        for (int number : set) {
            if (!set.contains(number - 1)) {
                int currentNumber = number;
                int currentStreak = 1;
                while (set.contains(currentNumber + 1)) {
                    currentNumber++;
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
    public static void main(String[] args) {
        int[] array = {100, 4, 200, 1, 3, 2};
        System.out.println("Length of longest consecutive sequence: " + longestConsecutive(array));
    }
}
