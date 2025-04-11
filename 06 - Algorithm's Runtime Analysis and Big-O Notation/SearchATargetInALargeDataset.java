import java.util.Arrays;
import java.util.Random;

public class SearchATargetInALargeDataset {

    public static void main(String[] args) {
        int[] sizes = {1_000, 10_000, 1_000_000};
        int target = -1;

        for (int size : sizes) {
            int[] data = generateData(size);

            long startTime = System.nanoTime();
            linearSearch(data, target);
            long endTime = System.nanoTime();
            long linearTime = endTime - startTime;

            Arrays.sort(data);
            startTime = System.nanoTime();
            binarySearch(data, target);
            endTime = System.nanoTime();
            long binaryTime = endTime - startTime;

            System.out.printf("Dataset Size: %,d%n", size);
            System.out.printf("Linear Search Time: %.3f ms%n", linearTime / 1_000_000.0);
            System.out.printf("Binary Search Time: %.3f ms%n%n", binaryTime / 1_000_000.0);
        }
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static int[] generateData(int size) {
        Random rand = new Random();
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = rand.nextInt(size * 2);
        }
        return data;
    }
}