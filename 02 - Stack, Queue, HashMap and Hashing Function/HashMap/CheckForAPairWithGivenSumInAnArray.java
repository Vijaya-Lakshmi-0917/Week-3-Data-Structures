import java.util.HashSet;
public class CheckForAPairWithGivenSumInAnArray {
    public static boolean hasPairWithSum(int[] arr, int target) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                System.out.println("Pair found: (" + complement + ", " + num + ")");
                return true;
            }
            seen.add(num);
        }

        System.out.println("No pair with the given sum found.");
        return false;
    }

    public static void main(String[] args) {
        int[] array = {4, 7, 1, -3, 2};
        int target = -1;

        hasPairWithSum(array, target);
    }
}

