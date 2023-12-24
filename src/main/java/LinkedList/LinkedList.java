package LinkedList;

public class LinkedList {

    protected ListNode head;
    private ListNode tail;

    private int size;

    public LinkedList() {
        this.size = 0;
    }

    public static LinkedList merge(LinkedList l1, LinkedList l2) {

        ListNode h1 = l1.head;
        ListNode h2 = l2.head;

        LinkedList result = new LinkedList();

        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                result.insertLast(h1.val);
                h1 = h1.next;
            } else {
                result.insertLast(h2.val);
                h2 = h2.next;
            }
        }

        while (h1 != null) {
            result.insertLast(h1.val);
            h1 = h1.next;
        }

        while (h2 != null) {
            result.insertLast(h2.val);
            h2 = h2.next;
        }

        return result;
    }

    public void insertFirst(int val) {

        ListNode node = new ListNode(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }

        size++;
    }

    public void removeDuplicates() {

        ListNode temp = head;

        while (temp.next != null) {
            // How to modify a linked list? manipulate the next pointer.
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
                size--;
            } else {
                temp = temp.next;
            }
        }
        tail = temp;
        tail.next = null;
    }

    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null && fast != slow) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return fast == slow;
    }

    public int cycleLength(ListNode node) {

        if (head == null) {
            return 0;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null && fast != slow) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = slow;
        int count = 0;
        do {
            temp = temp.next;
            count++;
        } while (temp != slow);

        return count;
    }

    /**
     * Reverse a linked list using iterative approach.
     */
    public ListNode reverse(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode prev = null;
        ListNode pres = head;
        ListNode next = pres.next;

        while (pres != null) {
            pres.next = prev;
            prev = pres;
            pres = next;

            if (next != null) {
                next = next.next;
            }
        }

        head = prev;
        return head;
    }

    public void reverseRec(ListNode node) {
        if (node == tail) {
            head = tail;
            return;
        }

        reverseRec(node.next);
        // Adding reverse link.
        tail.next = node;
        // moving tail one step back.
        tail = node;
        // removing the old forward link.
        tail.next = null;
    }


    public void reorder() {
        if (head == null) {
            return;
        }

        ListNode mid = middleNode(head);
        ListNode headSecond = reverse(mid);

        while (head != null && headSecond != null) {
            ListNode headNextCache = head.next;
            ListNode headSecondNextCache = headSecond.next;
            head.next = headSecond;
            headSecond.next = headNextCache;
            head = headNextCache;
            headSecond = headSecondNextCache;
        }

        if (head != null) {
            head.next = null;
        }
    }

    public ListNode reverseKGroup(int k) {

        int first = 1;
        int second = first + k - 1;
        int size = getSize(head);
        while (second <= size) {
            ListNode reversed = reverseBetween(head, first, second);
            head = reversed;
            first = second + 1;
            second = first + k - 1;
        }

        return head;
    }

    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }

    /**
     * Revise tonight and tomorrow.
     */
    public ListNode reverseBetweenKunal(ListNode head, int left, int right) {

        if (left == right) {
            return head;
        }

        ListNode current = head;
        ListNode prev = null;

        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        ListNode last = prev;
        ListNode newEnd = current;

        //reverse between left and right.
        ListNode next = current.next;

        for (int i = 0; current != null && i < (right - left) + 1; i++) {
            current.next = prev;
            prev = current;
            current = next;

            if(next != null){
                next = next.next;
            }
        }

        if(last != null){
            last.next = prev;
        }else {
            head = prev;
        }

        newEnd.next = current;
        return head;
    }


    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (left == right) {
            return head;
        }

        // skip the first  n-1 nodes.
        ListNode current = head;
        ListNode previous = null;

        for (int i = 0; current != null && i < left - 1; i++) {
            previous = current;
            current = current.next;
        }

        // Cache to be used later.
        ListNode last = previous;
        ListNode newEnd = current;

        // Now actually reverse
        ListNode next = current.next;
        for (int i = 0; current != null && i < right - left + 1; i++) {
            current.next = previous;
            previous = current;
            current = next;

            if (next != null) {
                next = next.next;
            }
        }
        if (last != null) {
            last.next = previous;
        } else {
            head = previous;
        }

        newEnd.next = current;
        return head;
    }

    public ListNode rotateRight(int k) {

        if (head == null || head.next == null) {
            return head;
        }

        int size = getSize(head);

        k = k % size;

        while (k > 0) {

            ListNode prev = head;
            ListNode current = head.next;

            ListNode cacheHead = head;

            while (current.next != null) {
                prev = current;
                current = current.next;
            }

            current.next = cacheHead;
            prev.next = null;
            head = current;
            k--;
        }
        return head;
    }

    public ListNode rotateRightOptimized(int k) {

        if (k < 0 || head == null || head.next == null) {
            return head;
        }

        int size = getSize(head);

        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = head;


        int rotations = k % size;

        ListNode headPointer = head;

        for (int i = 0; i < (size - rotations - 1); i++) {
            headPointer = headPointer.next;
        }
        head = headPointer.next;
        headPointer.next = null;
        return head;
    }


    public ListNode sort(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = sort(head);
        ListNode right = sort(mid);

        return merge(left, right);
    }

    /**
     * After calculating mid, update the head also. i.e. head will be every thing before the mid.
     */
    ListNode getMid(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // We need midPrev to bisect the list and get the first half. We do midprev.next=null,so that we get
        //elements before mid.
        ListNode midPrev = null;

        while (fast != null && fast.next != null) {
            midPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        assert slow != null;
        ListNode mid = slow;
        assert midPrev != null;
        midPrev.next = null;
        return mid;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode headSecond = reverse(mid);
        ListNode toRereverse = headSecond;

        while (head != null && headSecond != null) {
            if (head.val != headSecond.val) {
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }

        reverse(toRereverse);
        return head == null || headSecond == null;
    }

    public void bubbleSort() {
        bubbleSort(size - 1, 0);
    }

    private void bubbleSort(int row, int col) {

        if (row == 0) {
            return;
        }

        if (col < row) {

            ListNode first = get(col);
            ListNode second = get(col + 1);

            if (first.val > second.val) {

                // When the first node is the head.
                if (first == head) {
                    // create the diagram after swapping and the code becomes obvious.
                    head = second;
                    first.next = second.next;
                    second.next = first;

                    // When the second node is the tail.
                } else if (second == tail) {
                    ListNode prev = get(col - 1);
                    prev.next = second;
                    second.next = first;
                    tail = first;
                    tail.next = null;
                } else {
                    ListNode prev = get(col - 1);
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

    public ListNode middleNode(ListNode head) {

        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    public ListNode merge(ListNode list1, ListNode list2) {

        // THis dummy head is used as an extra variable to ensure that the initial empty node is not returned.
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
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

    private ListNode insertRec(int val, int index, ListNode node) {

        if (index == 0) {
            ListNode temp = new ListNode(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index - 1, node.next);
        return node;
    }


    public int deleteFirst() {

        int val = head.val;
        head = head.next;

        // There is only one element in the linked list.f
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

        ListNode beforeNode = get(index - 1);

        int value = beforeNode.next.val;

        beforeNode.next = beforeNode.next.next;

        return value;

    }

    public ListNode findNodeByValue(int value) {

        ListNode temp = head;

        while (temp != null) {
            if (temp.val == value) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    private ListNode get(int index) {

        ListNode temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public int deleteLast() {

        if (size <= 1) {
            return deleteFirst();
        }

        ListNode secondLast = get(size - 2);
        // we can also get the pointer to second last node with for loop from i=0 to size - 2.

        int val = tail.val;
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

        ListNode temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        ListNode newNode = new ListNode(val, temp.next);
        temp.next = newNode;

        size++;

    }


    public void insertLast(int val) {

        if (tail == null) {
            insertFirst(val);
            return;
        }

        ListNode node = new ListNode(val);
        tail.next = node;
        tail = node;

        size++;
    }


    public void display() {

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("END");

    }


    public class ListNode {
        private int val;
        private ListNode next;

        public ListNode() {
        }

        public ListNode(int value) {
            this.val = value;
        }

        public ListNode(int value, ListNode next) {
            this.val = value;
            this.next = next;
        }
    }
}
