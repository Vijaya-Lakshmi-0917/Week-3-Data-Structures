public class StockSpanProblem {
    static class Stack {
        int[] arr;
        int top;
        int capacity;

        public Stack(int size) {
            arr = new int[size];
            top = -1;
            capacity = size;
        }

        public void push(int value) {
            arr[++top] = value;
        }

        public int pop() {
            return arr[top--];
        }

        public int peek() {
            return arr[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack stack = new Stack(n);

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            span[i] = (stack.isEmpty()) ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculateSpan(prices);

        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}