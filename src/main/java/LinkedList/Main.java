package LinkedList;

public class Main {

    public static void main(String[] args) {

//        LinkedList linkedList = new LinkedList();
//        linkedList.insertFirst(5);
//        linkedList.insertFirst(9);
//        linkedList.insertFirst(8);
//        linkedList.insertFirst(4);
//        linkedList.insertFirst(1);
//
//        linkedList.insert(500, 2);
//
//        linkedList.insertLast(100);
//        linkedList.insertLast(120);
//
//         linkedList.display();
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

        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.insert(3);
        circularLinkedList.insert(4);
        circularLinkedList.insert(5);
        circularLinkedList.display();
        circularLinkedList.delete(3);
        circularLinkedList.display();
    }
}
