import java.util.Arrays;
import java.util.Random;

public class SortingLargeDataEfficiently {
    public static void main(String[] args) {
        int[] sizes = {1000, 10_000, 100_000};
        for (int size : sizes) {
            int[] original = generateData(size);

            if (size <= 10_000) {
                int[] bubbleArray = Arrays.copyOf(original, original.length);
                long start = System.nanoTime();
                bubbleSort(bubbleArray);
                long end = System.nanoTime();
                System.out.printf("Bubble Sort (%d): %.3f ms%n", size, (end - start) / 1_000_000.0);
            } else {
                System.out.printf("Bubble Sort (%d): Skipped (too slow)%n", size);
            }

            int[] mergeArray = Arrays.copyOf(original, original.length);
            long start = System.nanoTime();
            mergeSort(mergeArray, 0, mergeArray.length - 1);
            long end = System.nanoTime();
            System.out.printf("Merge Sort (%d): %.3f ms%n", size, (end - start) / 1_000_000.0);

            int[] quickArray = Arrays.copyOf(original, original.length);
            start = System.nanoTime();
            quickSort(quickArray, 0, quickArray.length - 1);
            end = System.nanoTime();
            System.out.printf("Quick Sort (%d): %.3f ms%n\n\n", size, (end - start) / 1_000_000.0);
        }
    }

    public static int[] generateData(int size) {
        Random rand = new Random();
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = rand.nextInt();
        }
        return data;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] L = Arrays.copyOfRange(arr, left, mid + 1);
        int[] R = Arrays.copyOfRange(arr, mid + 1, right + 1);
        int i = 0, j = 0, k = left;
        while (i < L.length && j < R.length) {
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        }
        while (i < L.length) arr[k++] = L[i++];
        while (j < R.length) arr[k++] = R[j++];
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }
}