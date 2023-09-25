package trees;

public class BST {

    private Node root;

    public BST() {

    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void display() {
        TreePrinter.printNode(root);
    }

    public void insert(int value) {

        if (root == null) {
            Node n = new Node(value);
            root = n;
            return;
        }

        insert(value, root);
    }

    private Node insert(int value, Node node) {

        if (node == null) {
            Node n = new Node(value);
            return n;
        }

        if (value < node.getValue()) {
            node.left = insert(value, node.left);
        }
        if (value > node.getValue()) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void populatedSorted(int[] nums) {
        populatedSorted(nums, 0, nums.length);
    }

    public void populatedSorted(int[] nums, int start, int end) {

        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        this.insert(nums[mid]);
        populatedSorted(nums, start, mid);
        populatedSorted(nums, mid + 1, end);
    }

    public static void main(String[] args) {
        BST bst = new BST();
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        bst.populatedSorted(arr);
        bst.display();
    }

}
