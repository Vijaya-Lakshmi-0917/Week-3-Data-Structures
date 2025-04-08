public class InsertionSort {
    public static void insertionSort(int[] ids) {
        int n = ids.length;
        for (int i = 1; i < n; i++) {
            int key = ids[i];
            int j = i - 1;

            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
            }
            ids[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] employeeIDs = {1045, 1023, 1078, 1001, 1050};

        insertionSort(employeeIDs);

        System.out.print("Sorted employee IDs: ");
        for (int id : employeeIDs) {
            System.out.print(id + " ");
        }
    }
}
