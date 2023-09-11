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

    public void removeDuplicates() {

        Node temp = head;

        while (temp.next != null) {
            // How to modify a linked list? manipulate the next pointer.
            if (temp.value == temp.next.value) {
                temp.next = temp.next.next;
                size--;
            } else {
                temp = temp.next;
            }
        }
        tail = temp;
        tail.next = null;
    }

    public static LinkedList merge(LinkedList l1, LinkedList l2) {

        Node h1 = l1.head;
        Node h2 = l2.head;

        LinkedList result = new LinkedList();

        while (h1 != null && h2 != null) {
            if (h1.value < h2.value) {
                result.insertLast(h1.value);
                h1 = h1.next;
            } else {
                result.insertLast(h2.value);
                h2 = h2.next;
            }
        }

        while (h1 != null) {
            result.insertLast(h1.value);
            h1 = h1.next;
        }

        while (h2 != null) {
            result.insertLast(h2.value);
            h2 = h2.next;
        }

        return result;
    }

    public boolean hasCycle(Node head) {

        if (head == null) {
            return false;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null && fast != slow) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return fast == slow;
    }

    public int cycleLength(Node node) {

        if (head == null) {
            return 0;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null && fast != slow) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node temp = slow;
        int count = 0;
        do {
            temp = temp.next;
            count++;
        } while (temp != slow);

        return count;
    }

    public Node sort(Node head) {

        Node temp = head;

        if (temp == null || temp.next == null) {
            return temp;
        }

        Node mid = middleNode(temp);
        Node left = sort(temp);
        Node right = sort(mid);

        return merge(left, right);
    }

    public void bubbleSort() {
        bubbleSort(size - 1, 0);
    }

    private void bubbleSort(int row, int col) {

        if (row == 0) {
            return;
        }

        if (col < row) {

            Node first = get(col);
            Node second = get(col + 1);

            if (first.value > second.value) {

                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    Node prev = get(col - 1);
                    prev.next = second;
                    second.next = first;
                    tail = first;
                    tail.next = null;
                } else {
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col + 1);
        } else {
            bubbleSort(row - 1, 0);
        }

    }

    public Node middleNode(Node head) {

        Node midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        Node mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    public Node merge(Node list1, Node list2) {

        // THis dummy head is used as an extra variable to ensure that the initial empty node is not returned.
        Node dummyHead = new Node();
        Node tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.value < list2.value) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    public void insertRec(int val, int index) {
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node) {

        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index - 1, node.next);
        return node;
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

        Node beforeNode = get(index - 1);

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

    private Node get(int index) {

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

        Node secondLast = get(size - 2);
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

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
