package LinkedList;

public class LinkedList {

    private Node head;
    private Node tail;

    private int size;

    public LinkedList() {
        this.size = 0;
    }

    public void insertFirst(int val) {

        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }

        size++;
    }

    public int deleteFirst() {

        int val = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        size--;

        return val;
    }

    public int delete(int index) {

        if (index == 0) {
            deleteFirst();
        }

        if (index == size - 1) {
            deleteLast();
        }

        Node beforeNode = getPreviousNode(index - 1);

        int value = beforeNode.next.value;

        beforeNode.next = beforeNode.next.next;

        return value;

    }

    public Node findNodeByValue(int value) {

        Node temp = head;

        while (temp != null) {
            if (temp.value == value) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    private Node getPreviousNode(int index) {

        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public int deleteLast() {

        if (size <= 1) {
            return deleteFirst();
        }

//        Node temp = head;
//
//        while (temp.next != tail) {
//            temp = temp.next;
//        }

        Node secondLast = getPreviousNode(size - 2);
        // we can also get the pointer to second last node with for loop from i=0 to size - 2.

        int val = tail.value;
        tail = secondLast;
        tail.next = null;

        size--;

        return val;


    }

    public void insert(int val, int index) {

        if (head == null) {
            insertFirst(val);
            return;
        }

        if (tail == null) {
            insertLast(val);
            return;
        }

        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(val, temp.next);
        temp.next = newNode;

        size++;

    }


    public void insertLast(int val) {

        if (tail == null) {
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        tail.next = node;
        tail = node;

        size++;
    }


    public void display() {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.println("END");

    }


    public class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
