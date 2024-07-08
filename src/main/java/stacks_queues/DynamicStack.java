package stacks_queues;

public class DynamicStack extends Stack {

    public DynamicStack() {
        super(); // it will call CustomStack()
    }

    public DynamicStack(int size) {
        super(size); // it will call CustomStack(int size)
    }

    @Override
    public boolean push(int item) {
        // this takes care of it being full
        if (this.isFull()) {
            // double the array size
            int[] temp = new int[data.length * 2];
            // copy all previous items in new data
            System.arraycopy(data, 0, temp, 0, data.length);
            data = temp;
        }

        // at this point we know that array is not full
        // insert item
        return super.push(item);
    }
}