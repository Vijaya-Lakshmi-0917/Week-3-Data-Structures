public class BubbleSort {
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] studentMarks = {85, 67, 90, 45, 76, 89, 55};

        bubbleSort(studentMarks);

        System.out.print("Sorted marks: ");
        for (int mark : studentMarks) {
            System.out.print(mark + " ");
        }
    }
}
