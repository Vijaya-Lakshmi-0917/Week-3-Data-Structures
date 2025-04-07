public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] num, int k) {
        if (num == null || num.length == 0 || k == 0) {
            return new int[0];
        }

        int n = num.length;
        int[] result = new int[n - k + 1];
        int[] window = new int[k];
        int front = 0, rear = -1;

        for (int i = 0; i < n; i++) {
            while (front <= rear && window[front] <= i - k) {
                front++;
            }

            while (front <= rear && num[window[rear]] <= num[i]) {
                rear--;
            }

            window[++rear] = i;

            if (i >= k - 1) {
                result[i - k + 1] = num[window[front]];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] num = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(num, k);

        for (int n : result) {
            System.out.print(n + " ");
        }
    }
}