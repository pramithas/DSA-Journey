package LinkedList.problems;

import LinkedList.LinkedList;

public class RemoveDuplicates {

    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList();
        myLinkedList.insertLast(1);
        myLinkedList.insertLast(1);
        myLinkedList.insertLast(2);
        myLinkedList.insertLast(2);
        myLinkedList.display();
        myLinkedList.removeDuplicates();
        myLinkedList.display();
    }
}
