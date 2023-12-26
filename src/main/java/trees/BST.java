package trees;

import com.sun.source.tree.Tree;

public class BST {

    public TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public BST() {

    }

    public int height(TreeNode node) {
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

    public void insert(int val) {

        if (root == null) {
            TreeNode n = new TreeNode(val);
            root = n;
            return;
        }

        insert(val, root);
    }

    public TreeNode delete(int value) {
        return delete(this.root, value);
    }

    private TreeNode delete(TreeNode root, int value) {

        if (root == null) {
            return null;
        }

        // Recursive call to reach the node to be deleted.
        if (value < root.val) {
            root.left = delete(root.left, value);
            // Return statement is needed when the node reaches the null values.
            return root;
        } else if (value > root.val) {
            root.right = delete(root.right, value);
            return root;
        } else {
            // if both child are null, just return null. i.e.delete the node without any hassle,
            // since it is the only node.
            if (root.left == null && root.right == null) {
                return null;
            }

            // if only left present, replace the parent node left.
            if (root.left != null && root.right == null) {
                root.val = root.left.val;
                root.right = root.left.right;
                root.left = root.left.left;

                // This code below will not change the original root node but only the copy of the root node. So, the below code does not work. Above
                //code actually copies the below node to the place of node being deleted. So, it changes the structure of the original root.
                // root = root.left;
                return root;
            }

            if (root.left == null && root.right != null) {
                // root.value = root.right.value;
                // root.left = root.right.left;
                // root.right= root.right.right;
                root = root.right;
                return root;
            }

            if (root.left != null && root.right != null) {
                int smallest = smallestValue(root.right);
                root.val = smallest;
                root.right = delete(root.right, smallest);
                return root;
            }
        }
        return root;
    }

    public int smallestValue(TreeNode root) {
        return root.left == null ? root.val : smallestValue(root.left);
    }

    private TreeNode insert(int val, TreeNode treeNode) {

        if (treeNode == null) {
            TreeNode n = new TreeNode(val);
            return n;
        }

        // Keep on comparing the value and find the place where the new node can be added.
        // Why we do not need to maintain start and end pointer similar to the one we did for populating bst with random elements.
        // Here, the array is sorted, that is why this might not be needed. See in more depth.
        if (val < treeNode.val) {
            treeNode.left = insert(val, treeNode.left);
        }
        if (val > treeNode.val) {
            treeNode.right = insert(val, treeNode.right);
        }

        treeNode.height = Math.max(height(treeNode.left), height(treeNode.right)) + 1;

        return treeNode;
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
        int[] arr = {10, 5};
        bst.populate(arr);
        bst.delete(10);
    }

    private void populate(int[] arr) {
        for (int elem : arr) {
            insert(elem);
        }
    }
}
