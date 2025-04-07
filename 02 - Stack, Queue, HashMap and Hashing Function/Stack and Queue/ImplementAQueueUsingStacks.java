class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    private Node top;

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

class QueueUsingStacks {
    Stack stackEnqueue = new Stack();
    Stack stackDequeue = new Stack();

    public void enqueue(int data) {
        stackEnqueue.push(data);
    }

    public int dequeue() {
        if (stackDequeue.isEmpty()) {
            if (stackEnqueue.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }
        return stackDequeue.pop();
    }

    public int peek() {
        if (stackDequeue.isEmpty()) {
            if (stackEnqueue.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }
        return stackDequeue.peek();
    }

    public boolean isEmpty() {
        return stackEnqueue.isEmpty() && stackDequeue.isEmpty();
    }
}

public class ImplementAQueueUsingStacks{
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        queue.enqueue(40);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}