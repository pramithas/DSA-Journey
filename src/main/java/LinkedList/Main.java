package LinkedList;

import static LinkedList.LinkedList.merge;

public class Main {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        linkedList.insertLast(340);
        linkedList.insertLast(120);
        linkedList.insertLast(100);
        linkedList.insertLast(570);

        linkedList.display();

        linkedList.bubbleSort();

        linkedList.display();
    }
}
