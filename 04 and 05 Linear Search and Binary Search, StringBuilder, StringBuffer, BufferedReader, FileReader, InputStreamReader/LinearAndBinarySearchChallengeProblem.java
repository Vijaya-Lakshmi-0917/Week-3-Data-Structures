import java.util.Arrays;
public class LinearAndBinarySearchChallengeProblem {
    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        int target = 3;

        int firstMissingPositive = findFirstMissingPositive(arr);
        System.out.println("First missing positive integer: " + firstMissingPositive);

        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        int targetIndex = binarySearch(sortedArr, target);
        System.out.println("Index of target " + target + ": " + targetIndex);
    }
    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0 || arr[i] > n) {
                continue;
            }
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] > 0) {
                arr[index] = -arr[index];
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
