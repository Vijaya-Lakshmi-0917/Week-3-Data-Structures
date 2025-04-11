import java.util.*;
public class ComparingDifferentDataStructuresForSearching {
    public static void main(String[] args) {
        int size = 1_000_000;
        int target = size - 1;

        int[] array = new int[size];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < size; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        long start, end;

        start = System.nanoTime();
        boolean foundArray = linearSearch(array, target);
        end = System.nanoTime();
        System.out.printf("Array Search: %s, Time: %.2f ms%n", foundArray, (end - start) / 1_000_000.0);

        start = System.nanoTime();
        boolean foundHashSet = hashSet.contains(target);
        end = System.nanoTime();
        System.out.printf("HashSet Search: %s, Time: %.2f ms%n", foundHashSet, (end - start) / 1_000_000.0);

        start = System.nanoTime();
        boolean foundTreeSet = treeSet.contains(target);
        end = System.nanoTime();
        System.out.printf("TreeSet Search: %s, Time: %.2f ms%n", foundTreeSet, (end - start) / 1_000_000.0);
    }

    public static boolean linearSearch(int[] arr, int target) {
        for (int value : arr) {
            if (value == target) return true;
        }
        return false;
    }
}