package LinkedList;

import static LinkedList.LinkedList.merge;

public class Main {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        linkedList.insertLast(5);
        linkedList.insertLast(4);
        linkedList.insertLast(3);
        linkedList.insertLast(2);
        linkedList.insertLast(1);

        linkedList.display();

        //linkedList.sort(linkedList.head);
        linkedList.reverseRec(linkedList.head);

        //linkedList.bubbleSort();

       // linkedList.rotateRightOptimized(2);

        linkedList.display();
    }
}
