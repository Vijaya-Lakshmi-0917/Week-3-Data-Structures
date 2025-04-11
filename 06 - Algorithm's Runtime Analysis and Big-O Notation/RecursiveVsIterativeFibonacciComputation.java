public class RecursiveVsIterativeFibonacciComputation {
    public static void main(String[] args) {
        int n = 30;

        long start = System.nanoTime();
        int recursiveResult = fibonacciRecursive(n);
        long end = System.nanoTime();
        System.out.printf("Recursive Result: %d, Time: %.2f ms%n", recursiveResult, (end - start) / 1_000_000.0);

        start = System.nanoTime();
        int iterativeResult = fibonacciIterative(n);
        end = System.nanoTime();
        System.out.printf("Iterative Result: %d, Time: %.2f ms%n", iterativeResult, (end - start) / 1_000_000.0);
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}