public class HeapSort {
    public static void heapSort(int[] salaries) {
        int n = salaries.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heap(salaries, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;
            heap(salaries, i, 0);
        }
    }
    public static void heap(int[] salaries, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = temp;
            heap(salaries, n, largest);
        }
    }
    public static void main(String[] args) {
        int[] salaryDemands = {50000, 70000, 60000, 55000, 80000, 65000};
        heapSort(salaryDemands);
        System.out.print("Sorted salary demands: ");
        for (int salary : salaryDemands) {
            System.out.print(salary + " ");
        }
    }
}