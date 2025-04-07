class HashMap {
    static class Node {
        int key, value;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    Node[] buckets;
    int capacity;
    int size;
    final double LOAD_FACTOR = 0.75;
    HashMap() {
        capacity = 4;
        buckets = new Node[capacity];
        size = 0;
    }
    int index(int key) {
        return Integer.hashCode(key) & (capacity - 1);
    }
    void put(int key, int value) {
        if ((double)(size + 1) / capacity > LOAD_FACTOR) resize();
        int idx = index(key);
        Node head = buckets[idx];
        for (Node node = head; node != null; node = node.next) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }
        Node newNode = new Node(key, value);
        newNode.next = head;
        buckets[idx] = newNode;
        size++;
    }
    int get(int key) {
        int idx = index(key);
        for (Node node = buckets[idx]; node != null; node = node.next) {
            if (node.key == key) return node.value;
        }
        return -1;
    }
    void remove(int key) {
        int idx = index(key);
        Node current = buckets[idx], prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) buckets[idx] = current.next;
                else prev.next = current.next;
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }
    void resize() {
        Node[] oldBuckets = buckets;
        capacity *= 2;
        buckets = new Node[capacity];
        size = 0;
        for (Node head : oldBuckets) {
            for (Node node = head; node != null; node = node.next) {
                put(node.key, node.value);
            }
        }
    }
}
public class ImplementACustomHashMap {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put(10, 100);
        map.put(20, 200);
        map.put(30, 300);
        map.put(40, 400);

        System.out.println(map.get(10));
        System.out.println(map.get(30));

        map.remove(20);
        System.out.println(map.get(20));
    }
}