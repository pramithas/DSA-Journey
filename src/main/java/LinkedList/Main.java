package LinkedList;

import static LinkedList.LinkedList.merge;

public class Main {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
//        linkedList.insertFirst(5);
//        linkedList.insertFirst(9);
//        linkedList.insertFirst(8);
//        linkedList.insertFirst(4);
//        linkedList.insertFirst(1);
//
//        linkedList.insert(500, 2);
//
        linkedList.insertLast(100);
        linkedList.insertLast(120);
        linkedList.insertLast(340);
        linkedList.insertLast(570);

        LinkedList linkedList1 = new LinkedList();
        linkedList1.insertLast(1);
        linkedList1.insertLast(500);
        linkedList1.insertLast(1200);
//
        linkedList.display();
        linkedList1.display();

        LinkedList result = merge(linkedList, linkedList1);
        result.display();
////        System.out.println(linkedList.deleteFirst());
////        linkedList.display();
////        System.out.println(linkedList.deleteLast());
////        linkedList.display();
////        System.out.println(linkedList.deleteLast());
////        linkedList.display();
//
//        System.out.println(linkedList.delete(3));
//        linkedList.display();
//
//        linkedList.findNodeByValue(100);

//        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
//        doublyLinkedList.insertLast(5);
//        doublyLinkedList.insertLast(15);
//        doublyLinkedList.insertLast(25);
////        doublyLinkedList.insertFirst(5);
////        doublyLinkedList.insertFirst(66);
////        doublyLinkedList.insertFirst(1);
//        doublyLinkedList.display();
//        doublyLinkedList.insertAfter(0, 100);
//        doublyLinkedList.display();
        //doublyLinkedList.displayReverse();

//        CircularLinkedList circularLinkedList = new CircularLinkedList();
//        circularLinkedList.insert(3);
//        circularLinkedList.insert(4);
//        circularLinkedList.insert(5);
//        circularLinkedList.display();
//        circularLinkedList.delete(3);
//        circularLinkedList.display();
    }
}
