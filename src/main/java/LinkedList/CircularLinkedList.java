package LinkedList;

public class CircularLinkedList {

    private Node head;
    private Node tail;

    public CircularLinkedList() {
    }

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node() {
        }

    }


    public void insert(int value) {

        Node node = new Node(value);

        if (head == null) {
            head = node;
            tail = node;
        }

        tail.next = node;
        node.next = head;
        tail = node;
    }

    public Node delete(int value) {

        if (head == null) return null;

        // Find the required node
        Node curr = head, prev = new Node();
        while (curr.value != value) {
            if (curr.next == head) {
                // This is not the target node.
                System.out.printf("\nGiven node is not found" + " in the list!!!");
                break;
            }

            prev = curr;
            curr = curr.next;
        }

        // Check if node is only node and it is the target node.
        if (curr == head && curr.next == head) {
            head = null;
            return head;
        }

        // If more than one node, check if
        // it is first node
        // if we are trying to delete the head node and there are more than 1 node.
        if (curr == head) {
            prev = head;
            while (prev.next != head) prev = prev.next;
            head = curr.next;
            prev.next = head;
        }

        // check if node is last node or tail
        else if (curr.next == head) {
            prev.next = head;
        } else {
            prev.next = curr.next;
        }
        return head;
    }


    public void display() {

        Node node = head;

        if (head != null) {
            // do while is used because node is already head and we cannot use while(node != head) condition.
            do {
                System.out.print(node.value + " -> ");
                node = node.next;
            } while (node != head);
            System.out.println("END");
        }
    }


}
