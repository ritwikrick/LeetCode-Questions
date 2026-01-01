class MyLinkedList {

    class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public Node head;
    public int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;

        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        Node newnode = new Node(val);
        newnode.next = head;
        head = newnode;
        size++;
    }

    public void addAtTail(int val) {
        Node newnode = new Node(val);
        if (head == null) {
            head = newnode;
            size++;
            return;   // IMPORTANT
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newnode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        // boundary checks
        if (index < 0 || index > size) return;

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }

        Node curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        Node newnode = new Node(val);
        newnode.next = curr.next;
        curr.next = newnode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        Node curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;
        size--;
    }
}
