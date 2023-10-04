package heaps;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {

    private ArrayList<T> list;

    public Heap() {
        list = new ArrayList<>();
    }

    private void swap(int first, int second) {
        T temp = list.get(first);
        list.add(first, list.get(second));
        list.add(second, temp);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return (2 * index + 1);
    }

    private int right(int index) {
        return (2 * index + 2);
    }

    public void insert(T value) {
        list.add(value);
        upHeap(list.size() - 1);
    }

    private void upHeap(int index) {

        if (index == 0) {
            return;
        }

        int p = parent(index);

        if (list.get(index).compareTo(list.get(p)) < 0) {
            swap(index, p);
            upHeap(p);
        }
    }

    public T remove() throws Exception {

        if (list.isEmpty()) {
            throw new Exception("Removing from an empty heap !");
        }

        T temp = list.get(0);

        T last = list.remove(list.size() - 1);

        if (!list.isEmpty()) {
            list.set(0, last);
            downHeap(0);
        }
    }

    private void downHeap(int index) {

        int min = index;

        int left = left(index);
        int right = right(index);

        if (left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
            min = left;
        }

        if (right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
            min = right;
        }

        if (min != index) {
            swap(min, index);
            downHeap(min);
        }
    }

}
