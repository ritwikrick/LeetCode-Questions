
import java.util.*;
class LRUCache {
//It is a Java class used to create objects, where each object represents one node in the linked list.
//Because LRU Cache requires two data structures working together:

// 1️ HashMap → provides O(1) GET by key
// 2️ Doubly Linked List → maintains LRU order (which item is most recently used / least recently used)
    class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        // Dummy head and tail
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    // ✅ Get value
    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);

        remove(node);
        insertAtFront(node);

        return node.value;
    }

    // ✅ Put key-value
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertAtFront(node);
        } else {
            if (map.size() == capacity) {
                Node lru = tail.prev; // least recently used
                remove(lru);
                map.remove(lru.key);
            }

            Node newNode = new Node(key, value);
            insertAtFront(newNode);
            map.put(key, newNode);
        }
    }

    // ✅ Remove node from list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // ✅ Insert node right after head
    private void insertAtFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
}
