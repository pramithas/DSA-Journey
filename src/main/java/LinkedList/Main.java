package LinkedList;

import static LinkedList.LinkedList.merge;

public class Main {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        linkedList.insertLast(1);
        linkedList.insertLast(2);
        linkedList.insertLast(3);
        linkedList.insertLast(4);
        linkedList.insertLast(5);

        linkedList.display();

        //linkedList.bubbleSort();

        linkedList.rotateRightOptimized(2);

        linkedList.display();
    }
}
