package trees.problems.DFS;

import trees.BinaryTree;
import trees.TreeNode;

import java.util.Scanner;

/**
 * Revised on Jan 12.
 */
public class PathExists {

    public boolean findPath(TreeNode root, int[] arr) {

        if (root == null) {
            return arr.length == 0;
        }

        return helper(root, arr, 0);
    }

    private boolean helper(TreeNode root, int[] arr, int index) {

        if (root == null) {
            return false;
        }

        if (index >= arr.length || root.val != arr[index]) {
            return false;
        }

        // Why to return true in case of leaf node? Because, we are finding the path from
        // root to leaf. And, if we have reached the leaf node and root.val == arr[index],
        // we have found the path.
        // How is it that root.val == arr[index] ?
        if (root.left == null && root.right == null &&
                index == arr.length - 1) {
            return true;
        }

        return helper(root.left, arr, index + 1) ||
                helper(root.right, arr, index + 1);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.populate(new Scanner(System.in));
        binaryTree.display();
        int[] arr= {3,5,2};
        System.out.println(new PathExists().findPath(binaryTree.getRoot(), arr));
    }
}
