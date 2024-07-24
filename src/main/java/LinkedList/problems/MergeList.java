package LinkedList.problems;

import java.util.HashSet;
import java.util.Set;

public class MergeList {

    public static LinkedList mergingLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {

//        LinkedList list1 = linkedListOne, list2 = linkedListTwo;
//
//        while (list1 != list2) {
//            list1 = (list1 == null) ? linkedListTwo : list1.next;
//            list2 = (list2 == null) ? linkedListOne : list2.next;
//        }
//        return list1;
        LinkedList temp = linkedListOne;
        Set<Integer> listOneValues = new HashSet<>();
        while (temp != null) {
            listOneValues.add(temp.value);
            temp = temp.next;
        }

        LinkedList temp1 = linkedListTwo;

        while (temp1 != null) {
            if (listOneValues.contains(temp1.value)) {
                break;
            }
            temp1 = temp1.next;
        }
        return temp1;
    }

    public static void main(String[] args) {

        LinkedList node1 = new LinkedList(1);
        LinkedList node2 = new LinkedList(2);
        LinkedList node3 = new LinkedList(3);
        LinkedList node4 = new LinkedList(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        LinkedList node11 = new LinkedList(5);
        LinkedList node12 = new LinkedList(3);
        LinkedList node13 = new LinkedList(4);

        node11.next = node12;
        node12.next = node13;

        System.out.println(mergingLinkedLists(node1, node11));
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
