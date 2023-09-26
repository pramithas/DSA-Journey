package trees;

public class BST {

    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public BST() {

    }

    public int height(TreeNode TreeNode) {
        if (TreeNode == null) {
            return -1;
        }
        return TreeNode.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void display() {
        TreePrinter.printNode(root);
    }

    public void insert(int val) {

        if (root == null) {
            TreeNode n = new TreeNode(val);
            root = n;
            return;
        }

        insert(val, root);
    }

    private TreeNode insert(int val, TreeNode TreeNode) {

        if (TreeNode == null) {
            TreeNode n = new TreeNode(val);
            return n;
        }

        if (val < TreeNode.getValue()) {
            TreeNode.left = insert(val, TreeNode.left);
        }
        if (val > TreeNode.getValue()) {
            TreeNode.right = insert(val, TreeNode.right);
        }

        TreeNode.height = Math.max(height(TreeNode.left), height(TreeNode.right)) + 1;

        return TreeNode;
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(TreeNode TreeNode) {
        if (TreeNode == null) {
            return true;
        }
        return Math.abs(height(TreeNode.left) - height(TreeNode.right)) <= 1 && balanced(TreeNode.left) && balanced(TreeNode.right);
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

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }


    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        // In leaf nodes, just print the nodes. The recursive calls are just useless. Otherwise, first go recursively left and then right.
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }


    public static void main(String[] args) {
        BST bst = new BST();
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        bst.populatedSorted(arr);
//        bst.populate(arr);
        bst.display();
        bst.inOrder();
    }

    private void populate(int[] arr) {
        for (int elem : arr) {
            insert(elem);
        }
    }
}
