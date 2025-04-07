class SortingInAStack {
    int[] arr;
    int top;
    int capacity;

    public SortingInAStack(int size) {
        arr = new int[size];
        top = -1;
        capacity = size;
    }

    public void push(int value) {
        if (top == capacity - 1) {
            throw new RuntimeException("Stack Overflow");
        }
        arr[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        return arr[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class SortAStackUsingRecursion {
    public static void sort(SortingInAStack stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sort(stack);
            insertInSortedOrder(stack, temp);
        }
    }

    static void insertInSortedOrder(SortingInAStack stack, int value) {
        if (stack.isEmpty() || value > stack.peek()) {
            stack.push(value);
        } else {
            int temp = stack.pop();
            insertInSortedOrder(stack, value);
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        SortingInAStack stack = new SortingInAStack(10);
        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);
        stack.push(40);

        System.out.print("Original stack: ");
        stack.display();

        sort(stack);

        System.out.print("Sorted stack in ascending Order: ");
        stack.display();
    }
}
