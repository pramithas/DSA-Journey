package LinkedList;

public class DoublyLinkedList {

    private Node head;

    private class Node {
        private int value;
        private Node next;
        private Node previous;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.previous = null;
        node.next = head;
        if (head != null) {
            head.previous = node;
        }
        head = node;
    }

    public void insertLast(int value) {

        if (head == null) {
            insertFirst(value);
            return;
        }

        Node temp = head;
        Node node = new Node(value);

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = node;
        node.previous = temp;
        node.next = null;
    }

    public void insertAfter(int index, int value) {

        Node insertAfter = getNodeAt(index);

        if (insertAfter == null) {
            System.out.println("The node at the given index was not found");
            return;
        }

        Node node = new Node(value);
        node.next = insertAfter.next;

        if (insertAfter.next != null) {
            insertAfter.next.previous = node;
        }
        insertAfter.next = node;
        node.previous = insertAfter;
    }

    public Node getNodeAt(int index) {

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void display() {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }

    public void displayReverse() {

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.previous;
        }

        System.out.println("START");
    }
}
