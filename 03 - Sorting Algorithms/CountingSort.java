public class CountingSort {
    public static void countingSort(int[] ages) {
        int maxAge = 18;
        int minAge = 10;
        int[] count = new int[maxAge - minAge + 1];
        for (int age : ages) {
            count[age - minAge]++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                ages[index++] = i + minAge;
                count[i]--;
            }
        }
    }
    public static void main(String[] args) {
        int[] studentAges = {15, 12, 10, 18, 16, 14, 17, 11, 13, 18};
        countingSort(studentAges);
        System.out.print("Sorted student ages: ");
        for (int age : studentAges) {
            System.out.print(age + " ");
        }
    }
}