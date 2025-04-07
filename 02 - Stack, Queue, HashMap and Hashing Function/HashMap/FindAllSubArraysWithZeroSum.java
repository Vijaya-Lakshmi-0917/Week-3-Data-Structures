import java.util.HashMap;

public class FindAllSubArraysWithZeroSum {
    public static void findZeroSumSubArrays(int[] arr) {
        HashMap<Integer, StringBuilder> map = new HashMap<>();
        int cumulativeSum = 0;

        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];

            if (cumulativeSum == 0) {
                printSubArray(arr, 0, i);
            }

            if (map.containsKey(cumulativeSum)) {
                StringBuilder indices = map.get(cumulativeSum);
                String[] parts = indices.toString().split(",");
                for (String s : parts) {
                    int start = Integer.parseInt(s.trim());
                    printSubArray(arr, start + 1, i);
                }
                map.put(cumulativeSum, indices.append(",").append(i));
            } else {
                map.put(cumulativeSum, new StringBuilder().append(i));
            }
        }
    }

    private static void printSubArray(int[] arr, int start, int end) {
        System.out.print("Sub-Array from index " + start + " to index " + end + ": ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {6, -1, 3, -2, -3, 1, 3, 1, -3};
        findZeroSumSubArrays(array);
    }
}

